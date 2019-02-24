using MyDAL;
using MySql.Data.MySqlClient;
using System;
using System.Data;
using System.Threading.Tasks;

namespace CoreDemo.AdoNet
{
    public class EasyDalTest
    {

        private IDbConnection Conn { get; set; }

        public async Task Test01()
        {

            var Conn = new MySqlConnection("Server=localhost; Database=MyDAL_TestDB; Uid=SkyUser; Pwd=Sky@4321;SslMode=none;").OpenDebug();

            var agent = await Conn
                .Queryer<Agent>()
                .Where(it => it.Id == Guid.Parse("000c1569-a6f7-4140-89a7-0165443b5a4b"))
                .FirstOrDefaultAsync();

            var tuple = (XDebug.SQL, XDebug.Parameters, XDebug.SqlWithParams);

            var xx = "";

        }

    }

    [XTable("Agent")]
    public class Agent
    {
        public Agent() { }
        public Agent(string s1, int i2, decimal d3) { }

        public Guid Id { get; set; }

        public DateTime CreatedOn { get; set; }

        public Guid UserId { get; set; }

        public string PathId { get; set; }

        public string Name { get; set; }


        public string Phone { get; set; }

        public string IdCardNo { get; set; }

        public string CrmUserId { get; set; }

        public AgentLevel? AgentLevel { get; set; }

        public DateTime? ActivedOn { get; set; }

        public Guid? ActiveOrderId { get; set; }

        public int DirectorStarCount { get; set; }
    }
    public enum AgentLevel
    {
        //None = 0,
        NewCustomer = 1,
        Customer = 2,
        CityAgent = 4,
        ProvinceAgent = 16,
        DistiAgent = 128
    }
}
