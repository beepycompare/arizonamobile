package io.appmetrica.analytics.networktasks.internal;

import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class RequestDataHolder {

    /* renamed from: a  reason: collision with root package name */
    private NetworkTask.Method f1245a = NetworkTask.Method.GET;
    private final HashMap b = new HashMap();
    private byte[] c = null;
    private Long d;
    private Integer e;

    public void applySendTime(long j) {
        this.d = Long.valueOf(j);
        this.e = Integer.valueOf(((GregorianCalendar) Calendar.getInstance()).getTimeZone().getOffset(TimeUnit.MILLISECONDS.toSeconds(j) * 1000) / 1000);
    }

    public Map<String, List<String>> getHeaders() {
        return this.b;
    }

    public NetworkTask.Method getMethod() {
        return this.f1245a;
    }

    public byte[] getPostData() {
        return this.c;
    }

    public Long getSendTimestamp() {
        return this.d;
    }

    public Integer getSendTimezoneSec() {
        return this.e;
    }

    public void setHeader(String str, String... strArr) {
        this.b.put(str, Arrays.asList(strArr));
    }

    public void setPostData(byte[] bArr) {
        this.f1245a = NetworkTask.Method.POST;
        this.c = bArr;
    }
}
