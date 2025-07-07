package com.adjust.sdk;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public class ActivityPackage implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = -35935556512024097L;
    private ActivityKind activityKind;
    private Map<String, String> callbackParameters;
    private long clickTimeInMilliseconds;
    private long clickTimeInSeconds;
    private long clickTimeServerInSeconds;
    private String clientSdk;
    public transient AdjustEvent event;
    private int firstErrorCode;
    private Boolean googlePlayInstant;
    private transient int hashCode;
    private long installBeginTimeInSeconds;
    private long installBeginTimeServerInSeconds;
    private String installVersion;
    private Boolean isClick;
    private int lastErrorCode;
    private Map<String, String> parameters;
    private Map<String, String> partnerParameters;
    private String path;
    private OnPurchaseVerificationFinishedListener purchaseVerificationCallback;
    private int retries;
    private int retryCount;
    private String suffix;
    private double waitBeforeSendTimeSeconds;

    static {
        ObjectStreamField objectStreamField = new ObjectStreamField("path", String.class);
        ObjectStreamField objectStreamField2 = new ObjectStreamField("clientSdk", String.class);
        ObjectStreamField objectStreamField3 = new ObjectStreamField("parameters", Map.class);
        ObjectStreamField objectStreamField4 = new ObjectStreamField("activityKind", ActivityKind.class);
        ObjectStreamField objectStreamField5 = new ObjectStreamField("suffix", String.class);
        ObjectStreamField objectStreamField6 = new ObjectStreamField("callbackParameters", Map.class);
        ObjectStreamField objectStreamField7 = new ObjectStreamField("partnerParameters", Map.class);
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{objectStreamField, objectStreamField2, objectStreamField3, objectStreamField4, objectStreamField5, objectStreamField6, objectStreamField7, new ObjectStreamField("retryCount", cls), new ObjectStreamField("firstErrorCode", cls), new ObjectStreamField("lastErrorCode", cls), new ObjectStreamField("waitBeforeSendTimeSeconds", Double.TYPE)};
    }

    public ActivityPackage(ActivityKind activityKind) {
        ActivityKind activityKind2 = ActivityKind.UNKNOWN;
        this.activityKind = activityKind;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.path = Util.readStringField(readFields, "path", null);
        this.clientSdk = Util.readStringField(readFields, "clientSdk", null);
        this.parameters = (Map) Util.readObjectField(readFields, "parameters", null);
        this.activityKind = (ActivityKind) Util.readObjectField(readFields, "activityKind", ActivityKind.UNKNOWN);
        this.suffix = Util.readStringField(readFields, "suffix", null);
        this.callbackParameters = (Map) Util.readObjectField(readFields, "callbackParameters", null);
        this.partnerParameters = (Map) Util.readObjectField(readFields, "partnerParameters", null);
        this.retryCount = Util.readIntField(readFields, "errorCount", 0);
        this.firstErrorCode = Util.readIntField(readFields, "firstErrorCode", 0);
        this.lastErrorCode = Util.readIntField(readFields, "lastErrorCode", 0);
        this.waitBeforeSendTimeSeconds = Util.readDoubleField(readFields, "waitBeforeSendTimeSeconds", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }

    public void addError(int i) {
        this.retryCount++;
        if (this.firstErrorCode == 0) {
            this.firstErrorCode = i;
        } else {
            this.lastErrorCode = i;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityPackage activityPackage = (ActivityPackage) obj;
            return Util.equalString(this.path, activityPackage.path) && Util.equalString(this.clientSdk, activityPackage.clientSdk) && Util.equalObject(this.parameters, activityPackage.parameters) && Util.equalEnum(this.activityKind, activityPackage.activityKind) && Util.equalString(this.suffix, activityPackage.suffix) && Util.equalObject(this.callbackParameters, activityPackage.callbackParameters) && Util.equalObject(this.partnerParameters, activityPackage.partnerParameters) && Util.equalInt(Integer.valueOf(this.retryCount), Integer.valueOf(activityPackage.retryCount)) && Util.equalInt(Integer.valueOf(this.firstErrorCode), Integer.valueOf(activityPackage.firstErrorCode)) && Util.equalInt(Integer.valueOf(this.lastErrorCode), Integer.valueOf(activityPackage.lastErrorCode)) && Util.equalsDouble(Double.valueOf(this.waitBeforeSendTimeSeconds), Double.valueOf(activityPackage.waitBeforeSendTimeSeconds));
        }
        return false;
    }

    public ActivityKind getActivityKind() {
        return this.activityKind;
    }

    public Map<String, String> getCallbackParameters() {
        return this.callbackParameters;
    }

    public long getClickTimeInMilliseconds() {
        return this.clickTimeInMilliseconds;
    }

    public long getClickTimeInSeconds() {
        return this.clickTimeInSeconds;
    }

    public long getClickTimeServerInSeconds() {
        return this.clickTimeServerInSeconds;
    }

    public String getClientSdk() {
        return this.clientSdk;
    }

    public String getExtendedString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Util.formatString("Path:      %s\n", this.path));
        sb.append(Util.formatString("ClientSdk: %s\n", this.clientSdk));
        if (this.parameters != null) {
            sb.append("Parameters:");
            TreeMap treeMap = new TreeMap(this.parameters);
            List asList = Arrays.asList("secret_id", "adj_signing_id");
            for (Map.Entry entry : treeMap.entrySet()) {
                String str = (String) entry.getKey();
                if (!asList.contains(str)) {
                    sb.append(Util.formatString("\n\t%-16s %s", str, entry.getValue()));
                }
            }
        }
        return sb.toString();
    }

    public String getFailureMessage() {
        return Util.formatString("Failed to track %s%s", this.activityKind.toString(), this.suffix);
    }

    public int getFirstErrorCode() {
        return this.firstErrorCode;
    }

    public Boolean getGooglePlayInstant() {
        return this.googlePlayInstant;
    }

    public long getInstallBeginTimeInSeconds() {
        return this.installBeginTimeInSeconds;
    }

    public long getInstallBeginTimeServerInSeconds() {
        return this.installBeginTimeServerInSeconds;
    }

    public String getInstallVersion() {
        return this.installVersion;
    }

    public Boolean getIsClick() {
        return this.isClick;
    }

    public int getLastErrorCode() {
        return this.lastErrorCode;
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public Map<String, String> getPartnerParameters() {
        return this.partnerParameters;
    }

    public String getPath() {
        return this.path;
    }

    public OnPurchaseVerificationFinishedListener getPurchaseVerificationCallback() {
        return this.purchaseVerificationCallback;
    }

    public int getRetries() {
        return this.retries;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public double getWaitBeforeSendTimeSeconds() {
        return this.waitBeforeSendTimeSeconds;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            int hashString = Util.hashString(this.path, 17);
            this.hashCode = hashString;
            int hashString2 = Util.hashString(this.clientSdk, hashString);
            this.hashCode = hashString2;
            int hashObject = Util.hashObject(this.parameters, hashString2);
            this.hashCode = hashObject;
            int hashEnum = Util.hashEnum(this.activityKind, hashObject);
            this.hashCode = hashEnum;
            int hashString3 = Util.hashString(this.suffix, hashEnum);
            this.hashCode = hashString3;
            int hashObject2 = Util.hashObject(this.callbackParameters, hashString3);
            this.hashCode = hashObject2;
            this.hashCode = (((((Util.hashObject(this.partnerParameters, hashObject2) * 37) + this.retryCount) * 37) + this.firstErrorCode) * 37) + this.lastErrorCode;
            this.hashCode = Util.hashDouble(Double.valueOf(this.waitBeforeSendTimeSeconds), this.hashCode);
        }
        return this.hashCode;
    }

    public int increaseRetries() {
        int i = this.retries + 1;
        this.retries = i;
        return i;
    }

    public void setCallbackParameters(Map<String, String> map) {
        this.callbackParameters = map;
    }

    public void setClickTimeInMilliseconds(long j) {
        this.clickTimeInMilliseconds = j;
    }

    public void setClickTimeInSeconds(long j) {
        this.clickTimeInSeconds = j;
    }

    public void setClickTimeServerInSeconds(long j) {
        this.clickTimeServerInSeconds = j;
    }

    public void setClientSdk(String str) {
        this.clientSdk = str;
    }

    public void setGooglePlayInstant(Boolean bool) {
        this.googlePlayInstant = bool;
    }

    public void setInstallBeginTimeInSeconds(long j) {
        this.installBeginTimeInSeconds = j;
    }

    public void setInstallBeginTimeServerInSeconds(long j) {
        this.installBeginTimeServerInSeconds = j;
    }

    public void setInstallVersion(String str) {
        this.installVersion = str;
    }

    public void setIsClick(Boolean bool) {
        this.isClick = bool;
    }

    public void setParameters(Map<String, String> map) {
        this.parameters = map;
    }

    public void setPartnerParameters(Map<String, String> map) {
        this.partnerParameters = map;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setPurchaseVerificationCallback(OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        this.purchaseVerificationCallback = onPurchaseVerificationFinishedListener;
    }

    public void setSuffix(String str) {
        this.suffix = str;
    }

    public void setWaitBeforeSendTimeSeconds(double d) {
        this.waitBeforeSendTimeSeconds = d;
    }

    public String toString() {
        return Util.formatString("%s%s", this.activityKind.toString(), this.suffix);
    }
}
