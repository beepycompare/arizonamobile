package io.appmetrica.analytics.impl;

import android.content.Context;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.File;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\t¨\u0006\r"}, d2 = {"Lio/appmetrica/analytics/impl/b7;", "Lio/appmetrica/analytics/impl/a7;", "Landroid/content/Context;", "context", "", "simpleName", "Ljava/io/File;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lio/appmetrica/analytics/impl/Ug;", "Lio/appmetrica/analytics/impl/Ug;", "relativePathFormer", "<init>", "(Lio/appmetrica/analytics/impl/Ug;)V", "analytics_binaryProdRelease"}, k = 1, mv = {1, 6, 0})
/* renamed from: io.appmetrica.analytics.impl.b7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0149b7 implements InterfaceC0123a7 {

    /* renamed from: a  reason: collision with root package name */
    private final Ug f767a;

    public C0149b7(Ug ug) {
        this.f767a = ug;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0123a7
    public File a(Context context, String str) {
        return new File(context.getNoBackupFilesDir(), this.f767a.a(str));
    }
}
