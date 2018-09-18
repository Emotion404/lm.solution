using System;
using System.Collections.Generic;
using System.Data;
using System.Text;
using CoreDemo.AttributesDemo;
using EasyDAL.Exchange;

namespace CoreDemo.AdoNet
{
    public class EasyDalTest
    {

        private IDbConnection Conn { get; set; }

        public async void Test01()
        {

            //await Conn
            //    .Selecter<DbEntity>()
            //    .Where(it => it.Name == "xx")
            //    .

        }

    }
}
