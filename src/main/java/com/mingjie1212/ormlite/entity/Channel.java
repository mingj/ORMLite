package com.mingjie1212.ormlite.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by jeiao on 2016/9/11.
 */
@DatabaseTable(tableName = "Channel")
public class Channel {


    @DatabaseField(generatedId = true, allowGeneratedIdInsert = true)
    private int id;
    @DatabaseField(columnName = "name",columnDefinition = "VARCHAR(32)")
    private String name;
    @DatabaseField(columnName = "url", columnDefinition = "VARCHAR(255)")
    private String url;
    @DatabaseField(columnName = "icon_url", columnDefinition = "VARCHAR(255)")
    private String iconUrl;
    @DatabaseField(columnName = "intro", columnDefinition = "VARCHAR(255)")
    private String intro;

    @DatabaseField(columnName = "status",defaultValue ="0",canBeNull = false)
    private int status;
    @DatabaseField(columnName = "is_delete", defaultValue = "0", canBeNull = false)
    private int isDelete;





    public Channel() {
    }

    public Channel(String name) {
        this.name = name;
    }

    public Channel(int id, String name, String url, String iconUrl, String intro) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.iconUrl = iconUrl;
        this.intro = intro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
