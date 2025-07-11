package ru.mrlargha.commonui.elements.donate.domain;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ResultState.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lru/mrlargha/commonui/elements/donate/domain/ResultState;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "Success", "Error", "Lru/mrlargha/commonui/elements/donate/domain/ResultState$Error;", "Lru/mrlargha/commonui/elements/donate/domain/ResultState$Success;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ResultState<T> {
    public /* synthetic */ ResultState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ResultState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/donate/domain/ResultState$Success;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/mrlargha/commonui/elements/donate/domain/ResultState;", "data", "<init>", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lru/mrlargha/commonui/elements/donate/domain/ResultState$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Success<T> extends ResultState<T> {
        private final T data;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = success.data;
            }
            return success.copy(obj);
        }

        public final T component1() {
            return this.data;
        }

        public final Success<T> copy(T t) {
            return new Success<>(t);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual(this.data, ((Success) obj).data);
        }

        public int hashCode() {
            T t = this.data;
            if (t == null) {
                return 0;
            }
            return t.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.data + ")";
        }

        public Success(T t) {
            super(null);
            this.data = t;
        }

        public final T getData() {
            return this.data;
        }
    }

    private ResultState() {
    }

    /* compiled from: ResultState.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/donate/domain/ResultState$Error;", "Lru/mrlargha/commonui/elements/donate/domain/ResultState;", "", "message", "", "throwable", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getMessage", "()Ljava/lang/String;", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Error extends ResultState {
        private final String message;
        private final Throwable throwable;

        public static /* synthetic */ Error copy$default(Error error, String str, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.message;
            }
            if ((i & 2) != 0) {
                th = error.throwable;
            }
            return error.copy(str, th);
        }

        public final String component1() {
            return this.message;
        }

        public final Throwable component2() {
            return this.throwable;
        }

        public final Error copy(String message, Throwable th) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Error(message, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Error) {
                Error error = (Error) obj;
                return Intrinsics.areEqual(this.message, error.message) && Intrinsics.areEqual(this.throwable, error.throwable);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.message.hashCode() * 31;
            Throwable th = this.throwable;
            return hashCode + (th == null ? 0 : th.hashCode());
        }

        public String toString() {
            String str = this.message;
            return "Error(message=" + str + ", throwable=" + this.throwable + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String message, Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
            this.throwable = th;
        }

        public /* synthetic */ Error(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : th);
        }

        public final String getMessage() {
            return this.message;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }
    }
}
