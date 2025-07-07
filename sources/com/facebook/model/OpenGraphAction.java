package com.facebook.model;

import com.facebook.model.GraphObject;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface OpenGraphAction extends GraphObject {

    /* loaded from: classes3.dex */
    public static final class Factory {
        public static OpenGraphAction createForPost() {
            return (OpenGraphAction) GraphObject.Factory.create(OpenGraphAction.class);
        }
    }

    GraphObject getApplication();

    JSONObject getComments();

    Date getCreatedTime();

    GraphObject getData();

    Date getEndTime();

    Date getExpiresTime();

    GraphUser getFrom();

    String getId();

    List<JSONObject> getImage();

    JSONObject getLikes();

    String getMessage();

    GraphPlace getPlace();

    Date getPublishTime();

    String getRef();

    Date getStartTime();

    GraphObjectList<GraphObject> getTags();

    String getType();

    void setApplication(GraphObject graphObject);

    void setComments(JSONObject jSONObject);

    void setCreatedTime(Date date);

    void setData(GraphObject graphObject);

    void setEndTime(Date date);

    void setExpiresTime(Date date);

    void setFrom(GraphUser graphUser);

    void setId(String str);

    void setImage(List<JSONObject> list);

    @CreateGraphObject("url")
    @PropertyName("image")
    void setImageUrls(List<String> list);

    void setLikes(JSONObject jSONObject);

    void setMessage(String str);

    void setPlace(GraphPlace graphPlace);

    void setPublishTime(Date date);

    void setRef(String str);

    void setStartTime(Date date);

    void setTags(List<? extends GraphObject> list);

    void setType(String str);
}
