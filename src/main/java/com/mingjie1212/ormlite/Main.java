package com.mingjie1212.ormlite;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.mingjie1212.ormlite.entity.Channel;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by jeiao on 2016/9/11.
 */
public class Main {


    private static final Logger logger = LoggerFactory.getLogger(Main.class);


    static {
        try {
            //ע������
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws SQLException {

        String databaseUrl = "jdbc:sqlite:tv.db";

        //����һ��JDBC����
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        //ɾ����ͬʱ���Դ���
        TableUtils.dropTable(connectionSource, Channel.class, true);

        //����Table
        TableUtils.createTable(connectionSource, Channel.class);


        //ʵ����һ��DAO,�Ա�������ݲ���
        Dao<Channel, Integer> dao = DaoManager.createDao(connectionSource, Channel.class);


        //�������������
        Channel channel1 = new Channel("CCTV1");

        dao.create(channel1);

        Channel channel2 = new Channel("CCTV2");

        dao.create(channel2);


        //��ѯһ������

        Channel channel = dao.queryForId(1);
        logger.info(channel.getName());


//        //ɾ��һ����¼
//        dao.deleteById(2);
//        dao.delete(channel);


        //����һ����¼;
        channel.setIconUrl("http://sssss");
        dao.update(channel);

        //��������ѯ������¼����ҳ������ �����õ�QueryBuilder
        QueryBuilder<Channel, Integer> queryBuilder = dao.queryBuilder();

        queryBuilder.where().eq("is_delete", 0).and().eq("status", 0);
        queryBuilder.orderBy("id", false);
        queryBuilder.limit(10);

        List<Channel> channels = dao.query(queryBuilder.prepare());

        for (Channel channel3 : channels) {
            logger.info(channel3.getName());
        }



    }
}
