package androidx.media3.datasource;

import android.text.TextUtils;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import androidx.media3.datasource.DataSource;
import com.google.common.base.Ascii;
import com.google.common.base.Predicate;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public interface HttpDataSource extends DataSource {
    public static final Predicate<String> REJECT_PAYWALL_TYPES = new Predicate() { // from class: androidx.media3.datasource.HttpDataSource$$ExternalSyntheticLambda0
        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            return HttpDataSource.lambda$static$0((String) obj);
        }
    };

    /* loaded from: classes2.dex */
    public interface Factory extends DataSource.Factory {
        @Override // androidx.media3.datasource.DataSource.Factory
        HttpDataSource createDataSource();

        Factory setDefaultRequestProperties(Map<String, String> map);
    }

    void clearAllRequestProperties();

    void clearRequestProperty(String str);

    @Override // androidx.media3.datasource.DataSource
    void close() throws HttpDataSourceException;

    int getResponseCode();

    @Override // androidx.media3.datasource.DataSource
    Map<String, List<String>> getResponseHeaders();

    @Override // androidx.media3.datasource.DataSource
    long open(DataSpec dataSpec) throws HttpDataSourceException;

    @Override // androidx.media3.common.DataReader
    int read(byte[] bArr, int i, int i2) throws HttpDataSourceException;

    void setRequestProperty(String str, String str2);

    /* loaded from: classes2.dex */
    public static final class RequestProperties {
        private final Map<String, String> requestProperties = new HashMap();
        private Map<String, String> requestPropertiesSnapshot;

        public synchronized void set(String str, String str2) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.put(str, str2);
        }

        public synchronized void set(Map<String, String> map) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.putAll(map);
        }

        public synchronized void clearAndSet(Map<String, String> map) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.clear();
            this.requestProperties.putAll(map);
        }

        public synchronized void remove(String str) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.remove(str);
        }

        public synchronized void clear() {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.clear();
        }

        public synchronized Map<String, String> getSnapshot() {
            if (this.requestPropertiesSnapshot == null) {
                this.requestPropertiesSnapshot = Collections.unmodifiableMap(new HashMap(this.requestProperties));
            }
            return this.requestPropertiesSnapshot;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class BaseFactory implements Factory {
        private final RequestProperties defaultRequestProperties = new RequestProperties();

        protected abstract HttpDataSource createDataSourceInternal(RequestProperties requestProperties);

        @Override // androidx.media3.datasource.HttpDataSource.Factory, androidx.media3.datasource.DataSource.Factory
        public final HttpDataSource createDataSource() {
            return createDataSourceInternal(this.defaultRequestProperties);
        }

        @Override // androidx.media3.datasource.HttpDataSource.Factory
        public final Factory setDefaultRequestProperties(Map<String, String> map) {
            this.defaultRequestProperties.clearAndSet(map);
            return this;
        }
    }

    static /* synthetic */ boolean lambda$static$0(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = Ascii.toLowerCase(str);
        return (TextUtils.isEmpty(lowerCase) || (lowerCase.contains("text") && !lowerCase.contains(MimeTypes.TEXT_VTT)) || lowerCase.contains("html") || lowerCase.contains("xml")) ? false : true;
    }

    /* loaded from: classes2.dex */
    public static class HttpDataSourceException extends DataSourceException {
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public final DataSpec dataSpec;
        public final int type;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes2.dex */
        public @interface Type {
        }

        private static int assignErrorCode(int i, int i2) {
            return (i == 2000 && i2 == 1) ? PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED : i;
        }

        public static HttpDataSourceException createForIOException(IOException iOException, DataSpec dataSpec, int i) {
            int i2;
            String message = iOException.getMessage();
            if (iOException instanceof SocketTimeoutException) {
                i2 = PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT;
            } else if (iOException instanceof InterruptedIOException) {
                i2 = 1004;
            } else {
                i2 = (message == null || !Ascii.toLowerCase(message).matches("cleartext.*not permitted.*")) ? PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED : 2007;
            }
            if (i2 == 2007) {
                return new CleartextNotPermittedException(iOException, dataSpec);
            }
            return new HttpDataSourceException(iOException, dataSpec, i2, i);
        }

        @Deprecated
        public HttpDataSourceException(DataSpec dataSpec, int i) {
            this(dataSpec, 2000, i);
        }

        public HttpDataSourceException(DataSpec dataSpec, int i, int i2) {
            super(assignErrorCode(i, i2));
            this.dataSpec = dataSpec;
            this.type = i2;
        }

        @Deprecated
        public HttpDataSourceException(String str, DataSpec dataSpec, int i) {
            this(str, dataSpec, 2000, i);
        }

        public HttpDataSourceException(String str, DataSpec dataSpec, int i, int i2) {
            super(str, assignErrorCode(i, i2));
            this.dataSpec = dataSpec;
            this.type = i2;
        }

        @Deprecated
        public HttpDataSourceException(IOException iOException, DataSpec dataSpec, int i) {
            this(iOException, dataSpec, 2000, i);
        }

        public HttpDataSourceException(IOException iOException, DataSpec dataSpec, int i, int i2) {
            super(iOException, assignErrorCode(i, i2));
            this.dataSpec = dataSpec;
            this.type = i2;
        }

        @Deprecated
        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec, int i) {
            this(str, iOException, dataSpec, 2000, i);
        }

        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec, int i, int i2) {
            super(str, iOException, assignErrorCode(i, i2));
            this.dataSpec = dataSpec;
            this.type = i2;
        }
    }

    /* loaded from: classes2.dex */
    public static final class CleartextNotPermittedException extends HttpDataSourceException {
        public CleartextNotPermittedException(IOException iOException, DataSpec dataSpec) {
            super("Cleartext HTTP traffic not permitted. See https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted", iOException, dataSpec, PlaybackException.ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED, 1);
        }
    }

    /* loaded from: classes2.dex */
    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String contentType;

        public InvalidContentTypeException(String str, DataSpec dataSpec) {
            super("Invalid content type: " + str, dataSpec, (int) PlaybackException.ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE, 1);
            this.contentType = str;
        }
    }

    /* loaded from: classes2.dex */
    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final byte[] responseBody;
        public final int responseCode;
        public final String responseMessage;

        public InvalidResponseCodeException(int i, String str, IOException iOException, Map<String, List<String>> map, DataSpec dataSpec, byte[] bArr) {
            super("Response code: " + i, iOException, dataSpec, PlaybackException.ERROR_CODE_IO_BAD_HTTP_STATUS, 1);
            this.responseCode = i;
            this.responseMessage = str;
            this.headerFields = map;
            this.responseBody = bArr;
        }
    }
}
