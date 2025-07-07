package com.wardrumstudios.utils;
/* loaded from: classes4.dex */
public class MediaVaultRequest {
    private String ipAddress;
    private String mediaURL;
    private String pageURL;
    private String referrer;
    private long startTime = -1;
    private long endTime = -1;

    public MediaVaultRequest(String str) {
        this.mediaURL = str;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getHashParameters() {
        StringBuilder sb = new StringBuilder();
        String str = this.referrer;
        if (str != null) {
            sb.append(str);
        }
        String str2 = this.pageURL;
        if (str2 != null) {
            sb.append(str2);
        }
        return sb.toString();
    }

    public String getIPAddress() {
        return this.ipAddress;
    }

    public String getMediaURL() {
        return this.mediaURL;
    }

    public String getPageURL() {
        return this.pageURL;
    }

    public String getReferrer() {
        return this.referrer;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getURLParamers() {
        StringBuilder sb = new StringBuilder();
        sb.append("&p=100");
        if (this.referrer != null) {
            sb.append("&ru=1");
        }
        String str = this.pageURL;
        if (str != null && str.length() > 0) {
            sb.append("&pu=1");
        }
        String str2 = this.ipAddress;
        if (str2 != null && str2.length() > 0) {
            sb.append("&ip=" + this.ipAddress);
        }
        if (this.startTime != -1) {
            sb.append("&s=" + this.startTime);
        }
        if (this.endTime != -1) {
            sb.append("&e=" + this.endTime);
        }
        return sb.length() > 0 ? sb.substring(1) : sb.toString();
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setIPAddress(String str) {
        this.ipAddress = str;
    }

    public void setMediaURL(String str) {
        this.mediaURL = str;
    }

    public void setPageURL(String str) {
        this.pageURL = str;
    }

    public void setReferrer(String str) {
        this.referrer = str;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }
}
