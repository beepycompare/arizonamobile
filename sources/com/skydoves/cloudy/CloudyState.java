package com.skydoves.cloudy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CloudyState.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/skydoves/cloudy/CloudyState;", "", "Nothing", "Loading", "Success", "Error", "Lcom/skydoves/cloudy/CloudyState$Error;", "Lcom/skydoves/cloudy/CloudyState$Loading;", "Lcom/skydoves/cloudy/CloudyState$Nothing;", "Lcom/skydoves/cloudy/CloudyState$Success;", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface CloudyState {

    /* compiled from: CloudyState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lcom/skydoves/cloudy/CloudyState$Nothing;", "Lcom/skydoves/cloudy/CloudyState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Nothing implements CloudyState {
        public static final int $stable = 0;
        public static final Nothing INSTANCE = new Nothing();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Nothing) {
                Nothing nothing = (Nothing) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 870118315;
        }

        public String toString() {
            return "Nothing";
        }

        private Nothing() {
        }
    }

    /* compiled from: CloudyState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lcom/skydoves/cloudy/CloudyState$Loading;", "Lcom/skydoves/cloudy/CloudyState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Loading implements CloudyState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Loading) {
                Loading loading = (Loading) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -922555110;
        }

        public String toString() {
            return "Loading";
        }

        private Loading() {
        }
    }

    /* compiled from: CloudyState.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/skydoves/cloudy/CloudyState$Success;", "Lcom/skydoves/cloudy/CloudyState;", "Applied", "Captured", "Scrim", "Lcom/skydoves/cloudy/CloudyState$Success$Applied;", "Lcom/skydoves/cloudy/CloudyState$Success$Captured;", "Lcom/skydoves/cloudy/CloudyState$Success$Scrim;", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface Success extends CloudyState {

        /* compiled from: CloudyState.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lcom/skydoves/cloudy/CloudyState$Success$Applied;", "Lcom/skydoves/cloudy/CloudyState$Success;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Applied implements Success {
            public static final int $stable = 0;
            public static final Applied INSTANCE = new Applied();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Applied) {
                    Applied applied = (Applied) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -373771440;
            }

            public String toString() {
                return "Applied";
            }

            private Applied() {
            }
        }

        /* compiled from: CloudyState.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/skydoves/cloudy/CloudyState$Success$Captured;", "Lcom/skydoves/cloudy/CloudyState$Success;", "bitmap", "Lcom/skydoves/cloudy/PlatformBitmap;", "<init>", "(Lcom/skydoves/cloudy/PlatformBitmap;)V", "getBitmap", "()Lcom/skydoves/cloudy/PlatformBitmap;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Captured implements Success {
            public static final int $stable = 0;
            private final PlatformBitmap bitmap;

            public static /* synthetic */ Captured copy$default(Captured captured, PlatformBitmap platformBitmap, int i, Object obj) {
                if ((i & 1) != 0) {
                    platformBitmap = captured.bitmap;
                }
                return captured.copy(platformBitmap);
            }

            public final PlatformBitmap component1() {
                return this.bitmap;
            }

            public final Captured copy(PlatformBitmap bitmap) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                return new Captured(bitmap);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Captured) && Intrinsics.areEqual(this.bitmap, ((Captured) obj).bitmap);
            }

            public int hashCode() {
                return this.bitmap.hashCode();
            }

            public String toString() {
                return "Captured(bitmap=" + this.bitmap + ')';
            }

            public Captured(PlatformBitmap bitmap) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                this.bitmap = bitmap;
            }

            public final PlatformBitmap getBitmap() {
                return this.bitmap;
            }
        }

        /* compiled from: CloudyState.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lcom/skydoves/cloudy/CloudyState$Success$Scrim;", "Lcom/skydoves/cloudy/CloudyState$Success;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Scrim implements Success {
            public static final int $stable = 0;
            public static final Scrim INSTANCE = new Scrim();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Scrim) {
                    Scrim scrim = (Scrim) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 1901880409;
            }

            public String toString() {
                return "Scrim";
            }

            private Scrim() {
            }
        }
    }

    /* compiled from: CloudyState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/skydoves/cloudy/CloudyState$Error;", "Lcom/skydoves/cloudy/CloudyState;", "throwable", "", "<init>", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Error implements CloudyState {
        public static final int $stable = 0;
        private final Throwable throwable;

        public static /* synthetic */ Error copy$default(Error error, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = error.throwable;
            }
            return error.copy(th);
        }

        public final Throwable component1() {
            return this.throwable;
        }

        public final Error copy(Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            return new Error(throwable);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual(this.throwable, ((Error) obj).throwable);
        }

        public int hashCode() {
            return this.throwable.hashCode();
        }

        public String toString() {
            return "Error(throwable=" + this.throwable + ')';
        }

        public Error(Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.throwable = throwable;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }
    }
}
