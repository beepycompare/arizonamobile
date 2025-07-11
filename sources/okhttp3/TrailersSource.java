package okhttp3;

import java.io.IOException;
import kotlin.Metadata;
/* compiled from: TrailersSource.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lokhttp3/TrailersSource;", "", "peek", "Lokhttp3/Headers;", "get", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface TrailersSource {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final TrailersSource EMPTY = new TrailersSource() { // from class: okhttp3.TrailersSource$Companion$EMPTY$1
        @Override // okhttp3.TrailersSource
        public Headers peek() {
            return Headers.EMPTY;
        }

        @Override // okhttp3.TrailersSource
        public Headers get() {
            return Headers.EMPTY;
        }
    };

    Headers get() throws IOException;

    default Headers peek() throws IOException {
        return null;
    }

    /* compiled from: TrailersSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static Headers peek(TrailersSource trailersSource) throws IOException {
            return TrailersSource.super.peek();
        }
    }

    /* compiled from: TrailersSource.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, d2 = {"Lokhttp3/TrailersSource$Companion;", "", "<init>", "()V", "EMPTY", "Lokhttp3/TrailersSource;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
