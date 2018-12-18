using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text;

namespace CoreDemo.AdoNet
{
    public class MyDbContext: DbContext
    {
        public MyDbContext(DbContextOptions<MyDbContext> options)
            : base(options)
        {
        }
        public DbSet<TSqlCodeFirstCloumnType> TableOne { get; set; }
    }
    [Table("TSqlCodeFirstCloumnType")]
    public class TSqlCodeFirstCloumnType
    {
        public bool Bool { get; set; }  // bit(1) NOT NULL
        public bool? BoolNull { get; set; }  // bit(1) DEFAULT NULL

        /*
         * 8位
         * 无符号整数
         */
        public byte Byte { get; set; }  // tinyint(3) unsigned NOT NULL
        public byte? ByteNull { get; set; }  // tinyint(3) unsigned DEFAULT NULL

        public char Char { get; set; }  // varchar(1) NOT NULL
        public char? CharNull { get; set; }  // varchar(1) DEFAULT NULL

        public decimal Decimal { get; set; }  // decimal(65,30) NOT NULL
        public decimal? DecimalNull { get; set; }  // decimal(65,30) DEFAULT NULL

        public double Double { get; set; }  // double NOT NULL
        public double? DoubleNull { get; set; }  // double DEFAULT NULL

        public float Float { get; set; }  // float NOT NULL
        public float? FloatNull { get; set; }  // float DEFAULT NULL

        /*
         * 32位
         * 有符号整数
         */
        public int Int { get; set; }  // int(11) NOT NULL
        public int? IntNull { get; set; }  // int(11) DEFAULT NULL

        /*
         * 64位
         * 有符号整数
         */
        public long Long { get; set; } // bigint(20) NOT NULL
        public long? LongNull { get; set; } // bigint(20) DEFAULT NULL

        /*
         * 8位 
         * 有符号整数
         */
        public sbyte Sbyte { get; set; }  // tinyint(4) NOT NULL
        public sbyte? SbyteNull { get; set; }  // tinyint(4) DEFAULT NULL

        /*
         * 16位
         * 有符号整数
         */
        public short Short { get; set; }  // smallint(6) NOT NULL
        public short? ShortNull { get; set; }  // smallint(6) DEFAULT NULL

        /*
         * 32位
         * 无符号整数
         */
        public uint Uint { get; set; } // int(10) unsigned NOT NULL
        public uint? UintNull { get; set; }  // int(10) unsigned DEFAULT NULL

        /*
         * 64位
         * 无符号整数
         */
        public ulong Ulong { get; set; }  // bigint(20) unsigned NOT NULL
        public ulong? UlongNull { get; set; }  // bigint(20) unsigned DEFAULT NULL

        /*
         * 16位
         * 无符号整数
         */
        public ushort Ushort { get; set; }  // smallint(5) unsigned NOT NULL
        public ushort? UshortNull { get; set; }  // smallint(5) unsigned DEFAULT NULL

        /*
         * 不被 CodeFirst 支持的类型
         */
        [NotMapped]
        public object Object { get; set; }

        public string String { get; set; }  // longtext

        public DateTime DateTime { get; set; }  // datetime(6) NOT NULL
        public DateTime? DateTimeNull { get; set; }  // datetime(6) DEFAULT NULL

        public TimeSpan TimeSpan { get; set; }  // time(6) NOT NULL
        public TimeSpan? TimeSpanNull { get; set; }  // time(6) DEFAULT NULL

        public Guid Guid { get; set; }  // char(36) NOT NULL
        public Guid? GuidNull { get; set; }  // char(36) DEFAULT NULL

        public ActionEnum Enum { get; set; }  // int(11) NOT NULL
        public ActionEnum? EnumNull { get; set; }  // int(11) DEFAULT NULL

    }

    public enum ActionEnum
    {
        /// <summary>
        /// ""
        /// </summary>
        None,

        /// <summary>
        /// ""
        /// </summary>
        Insert,

        /// <summary>
        /// 
        /// </summary>
        Update,

        /// <summary>
        /// ""
        /// </summary>
        Select,

        /// <summary>
        /// ""
        /// </summary>
        From,

        /// <summary>
        /// " inner join "
        /// </summary>
        InnerJoin,

        /// <summary>
        /// " left join "
        /// </summary>
        LeftJoin,

        /// <summary>
        /// " on "
        /// </summary>
        On,

        /// <summary>
        /// " where "
        /// </summary>
        Where,

        /// <summary>
        /// " and "
        /// </summary>
        And,

        /// <summary>
        /// " or "
        /// </summary>
        Or,

        /// <summary>
        /// ""
        /// </summary>
        OrderBy
    }
}
