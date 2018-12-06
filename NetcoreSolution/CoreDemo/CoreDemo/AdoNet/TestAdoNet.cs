using System;
using System.Collections.Generic;
using System.Text;

namespace CoreDemo.AdoNet
{
    public class TestAdoNet
    {
        public void TestPoll()
        {
            (new PollAsync().PollTest()).GetAwaiter().GetResult();
        }

        public void testFirstOrDefault()
        {
            (new EasyDalTest().Test01()).GetAwaiter().GetResult();
        }
    }
}
