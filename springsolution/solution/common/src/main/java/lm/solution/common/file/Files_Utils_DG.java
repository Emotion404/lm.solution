package lm.solution.common.file;

import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public final class Files_Utils_DG {

    /**
     * 构造函数私有，以使此类不可构造实例
     */
    private Files_Utils_DG() {
        throw new Error("The class Cannot be instance !");
    }

    // 获取绝对路径
    public static String getServerPath(
            HttpServletRequest request,
            String filePath) {

        return request.getSession().getServletContext().getRealPath(filePath);

    }

    // 获取一个以日期命名的文件夹名 ; example:20160912
    public static String getDataPath() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    // 检查文件夹是否存在，不存在新建一个
    public static void checkDir(String savePath) {
        File dir = new File(savePath);
        if (!dir.exists() || !dir.isDirectory()) {
            // 不能创建多层目录
            //dir.mkdir();
            // 创建多层目录
            dir.mkdirs();
        }
    }

    // return an UUID Name parameter (suffix cover '.') example： ".jpg"、".txt"
    public static String getUUIDName(String suffix) {
        // make new file name
        return UUID.randomUUID().toString() + suffix;
    }

    // return server absolute path（real path） the style is  “server absolute
    // path/DataPath/UUIDName”filePath example "/files/Upload"
    public static String getAndSetAbsolutePath(
            HttpServletRequest request,
            String filePath,
            String suffix) {

        // example:F:/qixiao/files/Upload/20160912/
        String savePath = getServerPath(request, filePath) + File.separator + getDataPath() + File.separator;
        // check if the path has exist if not create it
        checkDir(savePath);
        return savePath + getUUIDName(suffix);

    }

    // get the relative path of files style is
    // “/filePath/DataPath/UUIDName”filePath example "/files/Upload"
    public static String getRelativePath(String filePath, String suffix) {
        // example:/files/Upload/20160912/
        return filePath + File.separator + getDataPath() + File.separator + getUUIDName(suffix);
    }

    /**
     * spring mvc files Upload method (transferTo method)
     * MultipartFile use TransferTo method upload
     *
     * @param request       HttpServletRequest
     * @param multipartFile MultipartFile(spring)
     * @param filePath      filePath example "/files/Upload"
     * @return
     */
    public static String FileUpload_transferTo_spring(
            HttpServletRequest request,
            MultipartFile multipartFile,
            String filePath) {

        if (multipartFile != null) {
            // get files suffix
            String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
            // filePath+fileName the complex file Name
            String absolutePath = getAndSetAbsolutePath(request, filePath, suffix);
            // return relative Path
            String relativePath = getRelativePath(filePath, suffix);

            try {
                // save file
                multipartFile.transferTo(new File(absolutePath));

                return relativePath;
            } catch (IOException ie) {
                ie.printStackTrace();
                return null;
            }

        } else {
            return null;
        }

    }

    /**
     * user stream type save files
     *
     * @param request       HttpServletRequest
     * @param multipartFile MultipartFile  support CommonsMultipartFile file
     * @param filePath      filePath example "/files/Upload"
     * @return
     */
    public static String FilesUpload_stream(
            HttpServletRequest request,
            MultipartFile multipartFile,
            String filePath) {

        if (multipartFile != null) {
            // get files suffix
            String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
            // filePath+fileName the complex file Name
            String absolutePath = getAndSetAbsolutePath(request, filePath, suffix);
            // return relative Path
            String relativePath = getRelativePath(filePath, suffix);
            try {
                InputStream inputStream = multipartFile.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);
                // create a buffer
                byte[] buffer = new byte[4096];
                long fileSize = multipartFile.getSize();

                if (fileSize <= buffer.length) {
                    buffer = new byte[(int) fileSize];
                }

                int line = 0;
                while ((line = inputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, line);
                }

                fileOutputStream.close();
                inputStream.close();

                return relativePath;

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }

        return null;
    }

    /**
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param filePath example "/filesOut/Download/mst.txt"
     *
     * @return
     * */
    public static void FilesDownload_stream(
            HttpServletRequest request,
            HttpServletResponse response,
            String filePath){

        // get server path (real path)
        String realPath=request.getSession().getServletContext().getRealPath(filePath);
        File file=new File(realPath);
        String filenames=file.getName();
        InputStream inputStream;
        try{
            inputStream=new BufferedInputStream(new FileInputStream(file));
            byte[] buffer=new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();
            response.reset();
            // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
            response.addHeader("Content-Disposition","attachment;filename="+new String(filenames.replaceAll(" ","").getBytes("UTF-8"),"iso8859-1"));
            response.addHeader("Content-Length",""+file.length());
            OutputStream os=new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            os.write(buffer);
            os.flush();
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
