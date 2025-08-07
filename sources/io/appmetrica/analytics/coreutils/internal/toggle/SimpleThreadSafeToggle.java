package io.appmetrica.analytics.coreutils.internal.toggle;

import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreapi.internal.control.ToggleObserver;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0004R\u001a\u0010\u0010\u001a\u00020\u000b8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/toggle/SimpleThreadSafeToggle;", "Lio/appmetrica/analytics/coreapi/internal/control/Toggle;", "Lio/appmetrica/analytics/coreapi/internal/control/ToggleObserver;", "toggleObserver", "", "sticky", "", "registerObserver", "removeObserver", "value", "updateState", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "getActualState", "()Z", "actualState", "initialState", "<init>", "(ZLjava/lang/String;)V", "core-utils_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public abstract class SimpleThreadSafeToggle implements Toggle {

    /* renamed from: a  reason: collision with root package name */
    private final String f299a;
    private boolean b;
    private final ArrayList c;

    public SimpleThreadSafeToggle(boolean z, String str) {
        this.f299a = str;
        this.b = z;
        this.c = new ArrayList();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.Toggle
    public synchronized boolean getActualState() {
        return this.b;
    }

    protected final String getTag() {
        return this.f299a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.Toggle
    public synchronized void registerObserver(ToggleObserver toggleObserver, boolean z) {
        this.c.add(toggleObserver);
        if (z) {
            toggleObserver.onStateChanged(getActualState());
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.Toggle
    public synchronized void removeObserver(ToggleObserver toggleObserver) {
        this.c.remove(toggleObserver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void updateState(boolean z) {
        if (z != getActualState()) {
            this.b = z;
            for (ToggleObserver toggleObserver : this.c) {
                toggleObserver.onStateChanged(z);
            }
        }
    }

    public /* synthetic */ SimpleThreadSafeToggle(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, str);
    }
}
