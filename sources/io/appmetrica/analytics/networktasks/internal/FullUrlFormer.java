package io.appmetrica.analytics.networktasks.internal;

import android.net.Uri;
import io.appmetrica.analytics.networktasks.impl.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FullUrlFormer<T> {

    /* renamed from: a  reason: collision with root package name */
    private List f1238a = new ArrayList();
    private int b = -1;
    private String c;
    private final IParamsAppender d;
    private final ConfigProvider e;

    public FullUrlFormer(IParamsAppender<T> iParamsAppender, ConfigProvider<T> configProvider) {
        this.d = iParamsAppender;
        this.e = configProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void buildAndSetFullHostUrl() {
        Uri.Builder buildUpon = Uri.parse((String) this.f1238a.get(this.b)).buildUpon();
        this.d.appendParams(buildUpon, this.e.getConfig());
        this.c = buildUpon.build().toString();
    }

    public List<String> getAllHosts() {
        return this.f1238a;
    }

    public String getUrl() {
        return new c(this.c).f1227a;
    }

    public boolean hasMoreHosts() {
        return this.b + 1 < this.f1238a.size();
    }

    public void incrementAttemptNumber() {
        this.b++;
    }

    public void setHosts(List<String> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f1238a = list;
    }
}
