package lm.solution.common.web.messageconverter;

import lm.solution.pojo.entity.web.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 继承 AbstractHttpMessageConverter 实现自定义 HttpMessageConverter
 * */
public class CustomMessageConverter extends AbstractHttpMessageConverter<DemoObj> {

    public CustomMessageConverter(){

        /**
         * 新建一个自定义的媒体类型 application/x-wisely
         * */
        super(new MediaType("application","x-wisely", Charset.forName("UTF-8")));

    }

    /**
     * 重写 readInternal 方法，处理请求数据
     * */
    @Override
    protected DemoObj readInternal(
            Class<? extends DemoObj> clazz,
            HttpInputMessage inputMessage
    ) throws IOException, HttpMessageNotReadableException {

        String temp= StreamUtils.copyToString(
                inputMessage.getBody(),
                Charset.forName("UTF-8"));

        String[] tempArr=temp.split("-");

        return new DemoObj(new Long(tempArr[0]),tempArr[1]);

    }

    /**
     * 表明 本类 只处理 DemoObj 类型
     * */
    @Override
    protected boolean supports(Class<?> clazz) {

        return DemoObj.class.isAssignableFrom(clazz);

    }

    /**
     * 处理如何输出数据
     * */
    @Override
    protected void writeInternal(
            DemoObj obj,
            HttpOutputMessage outputMessage
    ) throws IOException, HttpMessageNotWritableException {

        String out ="hello:"+obj.getId()+"-"+obj.getName();
        outputMessage.getBody().write(out.getBytes());

    }

}
