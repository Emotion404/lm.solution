using System;
using System.Data;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace CoreDemo.AdoNet
{
    public class PollAsync
    {
        public async Task PollTest()
        {

            MySqlConnection connection;
            MySqlCommand command = new MySqlCommand();
            MySqlDataReader reader;
            IAsyncResult asyncResult;

            Console.WriteLine("程序已启动……");
            connection = new MySqlConnection("Server=localhost; Database=Rainbow_Test_DB20180817; Uid=SkyUser; Pwd=Sky@4321;SslMode=none;");
            command.CommandText = "select * from agent ;";
            command.CommandType = CommandType.Text;
            command.Connection = connection;
            connection.Open();

            var start = DateTime.Now;
            asyncResult = command.BeginExecuteReader(CommandBehavior.CloseConnection);
            while (!asyncResult.IsCompleted)
            {
                Console.WriteLine("正在取资料……");
                Thread.Sleep(10);
            }

            reader = command.EndExecuteReader(asyncResult);
            var count = 0;
            while (await reader.ReadAsync())
            {
                count++;
            }
            var end = DateTime.Now;
            var timeSpan = end.Subtract(start);
            Console.WriteLine($"资料取出完成:{count.ToString()},总其用时{timeSpan.Milliseconds.ToString()}毫秒");

        }
    }
}
