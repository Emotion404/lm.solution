using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Logging;
using Senparc.Weixin.MP.CommonAPIs;
using Senparc.Weixin.MP.Containers;

namespace WebAppDemo
{
    public class Program
    {
        public static void Main(string[] args)
        {
            CreateWebHostBuilder(args).Build().Run();
        }

        public static IWebHostBuilder CreateWebHostBuilder(string[] args) =>
            WebHost.CreateDefaultBuilder(args)
                .UseStartup<Startup>();
    }

    public class AccessTokenTest
    {

        public void AccessTokenCon()
        {
            var result = CommonApi.GetToken("wx38d036665a0652d8", "");
            var xx = "";
        }

    }
}
