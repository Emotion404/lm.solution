
using Senparc.Weixin.MP.Containers;

namespace CoreDemo.Weixin
{
    public class AccessTokenTest
    {

        public void AccessTokenCon()
        {
            if (!AccessTokenContainer.CheckRegistered("wx38d036665a0652d8"))//检查是否已经注册
            {
                AccessTokenContainer.Register("wx38d036665a0652d8", "");//如果没有注册则进行注册
            }
            var result = AccessTokenContainer.GetAccessTokenResult("wx38d036665a0652d8"); //获取AccessToken结果
            var xx = "";
        }

    }
}
