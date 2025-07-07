package com.google.android.vending.expansion.downloader.impl;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import android.util.Log;
import androidx.compose.runtime.ComposerKt;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.android.vending.expansion.downloader.Helpers;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SyncFailedException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRouteParams;
/* loaded from: classes4.dex */
public class DownloadThread {
    private Context mContext;
    private final DownloadsDB mDB;
    private DownloadInfo mInfo;
    private final DownloadNotification mNotification;
    private DownloaderService mService;
    private String mUserAgent;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class InnerState {
        public int mBytesNotified;
        public int mBytesSoFar;
        public int mBytesThisSession;
        public boolean mContinuingDownload;
        public String mHeaderContentDisposition;
        public String mHeaderContentLength;
        public String mHeaderContentLocation;
        public String mHeaderETag;
        public long mTimeLastNotification;

        private InnerState() {
            this.mBytesSoFar = 0;
            this.mBytesThisSession = 0;
            this.mContinuingDownload = false;
            this.mBytesNotified = 0;
            this.mTimeLastNotification = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class RetryDownload extends Throwable {
        private static final long serialVersionUID = 6196036036517540229L;

        private RetryDownload() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class State {
        public String mFilename;
        public String mNewUri;
        public int mRedirectCount;
        public String mRequestUri;
        public FileOutputStream mStream;
        public boolean mCountRetry = false;
        public int mRetryAfter = 0;
        public boolean mGotData = false;

        public State(DownloadInfo downloadInfo, DownloaderService downloaderService) {
            this.mRedirectCount = 0;
            this.mRedirectCount = downloadInfo.mRedirectCount;
            this.mRequestUri = downloadInfo.mUri;
            this.mFilename = downloaderService.generateTempSaveFileName(downloadInfo.mFileName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class StopRequest extends Throwable {
        private static final long serialVersionUID = 6338592678988347973L;
        public int mFinalStatus;

        public StopRequest(int i, String str) {
            super(str);
            this.mFinalStatus = i;
        }

        public StopRequest(int i, String str, Throwable th) {
            super(str, th);
            this.mFinalStatus = i;
        }
    }

    public DownloadThread(DownloadInfo downloadInfo, DownloaderService downloaderService, DownloadNotification downloadNotification) {
        this.mContext = downloaderService;
        this.mInfo = downloadInfo;
        this.mService = downloaderService;
        this.mNotification = downloadNotification;
        this.mDB = DownloadsDB.getDB(downloaderService);
        this.mUserAgent = "APKXDL (Linux; U; Android " + Build.VERSION.RELEASE + ";" + Locale.getDefault().toString() + "; " + Build.DEVICE + RemoteSettings.FORWARD_SLASH_STRING + Build.ID + ")" + downloaderService.getPackageName();
    }

    private void addRequestHeaders(InnerState innerState, HttpGet httpGet) {
        if (innerState.mContinuingDownload) {
            if (innerState.mHeaderETag != null) {
                httpGet.addHeader("If-Match", innerState.mHeaderETag);
            }
            httpGet.addHeader("Range", "bytes=" + innerState.mBytesSoFar + Constants.FILENAME_SEQUENCE_SEPARATOR);
        }
    }

    private boolean cannotResume(InnerState innerState) {
        return innerState.mBytesSoFar > 0 && innerState.mHeaderETag == null;
    }

    private void checkConnectivity(State state) throws StopRequest {
        int networkAvailabilityState = this.mService.getNetworkAvailabilityState(this.mDB);
        if (networkAvailabilityState == 2) {
            throw new StopRequest(DownloaderService.STATUS_WAITING_FOR_NETWORK, "waiting for network to return");
        }
        if (networkAvailabilityState == 3) {
            throw new StopRequest(DownloaderService.STATUS_QUEUED_FOR_WIFI, "waiting for wifi");
        }
        if (networkAvailabilityState == 5) {
            throw new StopRequest(DownloaderService.STATUS_WAITING_FOR_NETWORK, "roaming is not allowed");
        }
        if (networkAvailabilityState == 6) {
            throw new StopRequest(DownloaderService.STATUS_QUEUED_FOR_WIFI_OR_CELLULAR_PERMISSION, "waiting for wifi or for download over cellular to be authorized");
        }
    }

    private void checkPausedOrCanceled(State state) throws StopRequest {
        if (this.mService.getControl() == 1 && this.mService.getStatus() == 193) {
            throw new StopRequest(this.mService.getStatus(), "download paused");
        }
    }

    private void cleanupDestination(State state, int i) {
        closeDestination(state);
        if (state.mFilename == null || !DownloaderService.isStatusError(i)) {
            return;
        }
        new File(state.mFilename).delete();
        state.mFilename = null;
    }

    private void closeDestination(State state) {
        try {
            if (state.mStream != null) {
                state.mStream.close();
                state.mStream = null;
            }
        } catch (IOException unused) {
        }
    }

    private void executeDownload(State state, AndroidHttpClient androidHttpClient, HttpGet httpGet) throws StopRequest, RetryDownload {
        InnerState innerState = new InnerState();
        checkPausedOrCanceled(state);
        setupDestinationFile(state, innerState);
        addRequestHeaders(innerState, httpGet);
        checkConnectivity(state);
        this.mNotification.onDownloadStateChanged(3);
        HttpResponse sendRequest = sendRequest(state, androidHttpClient, httpGet);
        handleExceptionalStatus(state, innerState, sendRequest);
        processResponseHeaders(state, innerState, sendRequest);
        InputStream openResponseEntity = openResponseEntity(state, sendRequest);
        this.mNotification.onDownloadStateChanged(4);
        transferData(state, innerState, new byte[4096], openResponseEntity);
    }

    private void finalizeDestinationFile(State state) throws StopRequest {
        syncDestination(state);
        String str = state.mFilename;
        String generateSaveFileName = Helpers.generateSaveFileName(this.mService, this.mInfo.mFileName);
        if (state.mFilename.equals(generateSaveFileName)) {
            return;
        }
        File file = new File(str);
        File file2 = new File(generateSaveFileName);
        if (this.mInfo.mTotalBytes == -1 || this.mInfo.mCurrentBytes != this.mInfo.mTotalBytes) {
            throw new StopRequest(DownloaderService.STATUS_FILE_DELIVERED_INCORRECTLY, "file delivered with incorrect size. probably due to network not browser configured");
        }
        if (!file.renameTo(file2)) {
            throw new StopRequest(492, "unable to finalize destination file");
        }
    }

    private int getFinalStatusForHttpError(State state) {
        if (this.mService.getNetworkAvailabilityState(this.mDB) != 1) {
            return DownloaderService.STATUS_WAITING_FOR_NETWORK;
        }
        if (this.mInfo.mNumFailed < 5) {
            state.mCountRetry = true;
            return DownloaderService.STATUS_WAITING_TO_RETRY;
        }
        Log.w(Constants.TAG, "reached max retries for " + this.mInfo.mNumFailed);
        return 495;
    }

    private void handleEndOfStream(State state, InnerState innerState) throws StopRequest {
        this.mInfo.mCurrentBytes = innerState.mBytesSoFar;
        this.mDB.updateDownload(this.mInfo);
        if (innerState.mHeaderContentLength == null || innerState.mBytesSoFar == Integer.parseInt(innerState.mHeaderContentLength)) {
            return;
        }
        if (!cannotResume(innerState)) {
            throw new StopRequest(getFinalStatusForHttpError(state), "closed socket before end of file");
        }
        throw new StopRequest(489, "mismatched content length");
    }

    private void handleExceptionalStatus(State state, InnerState innerState, HttpResponse httpResponse) throws StopRequest, RetryDownload {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == 503 && this.mInfo.mNumFailed < 5) {
            handleServiceUnavailable(state, httpResponse);
        }
        if (statusCode == 301 || statusCode == 302 || statusCode == 303 || statusCode == 307) {
            handleRedirect(state, httpResponse, statusCode);
        }
        if (statusCode != (innerState.mContinuingDownload ? ComposerKt.referenceKey : 200)) {
            handleOtherStatus(state, innerState, statusCode);
        } else {
            state.mRedirectCount = 0;
        }
    }

    private void handleOtherStatus(State state, InnerState innerState, int i) throws StopRequest {
        throw new StopRequest(!DownloaderService.isStatusError(i) ? (i < 300 || i >= 400) ? (innerState.mContinuingDownload && i == 200) ? 489 : 494 : 493 : i, "http error " + i);
    }

    private void handleRedirect(State state, HttpResponse httpResponse, int i) throws StopRequest, RetryDownload {
        if (state.mRedirectCount >= 10) {
            throw new StopRequest(497, "too many redirects");
        }
        Header firstHeader = httpResponse.getFirstHeader(HttpHeaders.LOCATION);
        if (firstHeader == null) {
            return;
        }
        try {
            String uri = new URI(this.mInfo.mUri).resolve(new URI(firstHeader.getValue())).toString();
            state.mRedirectCount++;
            state.mRequestUri = uri;
            if (i == 301 || i == 303) {
                state.mNewUri = uri;
            }
            throw new RetryDownload();
        } catch (URISyntaxException unused) {
            throw new StopRequest(495, "Couldn't resolve redirect URI");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (r3.mRetryAfter > 86400) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleServiceUnavailable(State state, HttpResponse httpResponse) throws StopRequest {
        int i;
        state.mCountRetry = true;
        Header firstHeader = httpResponse.getFirstHeader(HttpHeaders.RETRY_AFTER);
        if (firstHeader != null) {
            try {
                state.mRetryAfter = Integer.parseInt(firstHeader.getValue());
                if (state.mRetryAfter >= 0) {
                    int i2 = state.mRetryAfter >= 30 ? 86400 : 30;
                    state.mRetryAfter = i2;
                    state.mRetryAfter += Helpers.sRandom.nextInt(31);
                    i = state.mRetryAfter * 1000;
                } else {
                    i = 0;
                }
                state.mRetryAfter = i;
            } catch (NumberFormatException unused) {
            }
        }
        throw new StopRequest(DownloaderService.STATUS_WAITING_TO_RETRY, "got 503 Service Unavailable, will retry later");
    }

    private static final boolean isLocalHost(String str) {
        if (str != null) {
            try {
                String host = URI.create(str).getHost();
                if (host != null) {
                    if (host.equalsIgnoreCase("localhost") || host.equals("127.0.0.1")) {
                        return true;
                    }
                    if (host.equals("[::1]")) {
                        return true;
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        return false;
    }

    private void logNetworkState() {
        Log.i(Constants.TAG, "Net ".concat(this.mService.getNetworkAvailabilityState(this.mDB) == 1 ? "Up" : "Down"));
    }

    private void notifyDownloadCompleted(int i, boolean z, int i2, int i3, boolean z2, String str) {
        updateDownloadDatabase(i, z, i2, i3, z2, str);
        DownloaderService.isStatusCompleted(i);
    }

    private InputStream openResponseEntity(State state, HttpResponse httpResponse) throws StopRequest {
        try {
            return httpResponse.getEntity().getContent();
        } catch (IOException e) {
            logNetworkState();
            throw new StopRequest(getFinalStatusForHttpError(state), "while getting entity: " + e.toString(), e);
        }
    }

    private void processResponseHeaders(State state, InnerState innerState, HttpResponse httpResponse) throws StopRequest {
        if (innerState.mContinuingDownload) {
            return;
        }
        readResponseHeaders(state, innerState, httpResponse);
        try {
            state.mFilename = this.mService.generateSaveFile(this.mInfo.mFileName, this.mInfo.mTotalBytes);
            try {
                state.mStream = new FileOutputStream(state.mFilename);
            } catch (FileNotFoundException e) {
                try {
                    if (new File(Helpers.getSaveFilePath(this.mService)).mkdirs()) {
                        state.mStream = new FileOutputStream(state.mFilename);
                    }
                } catch (Exception unused) {
                    throw new StopRequest(492, "while opening destination file: " + e.toString(), e);
                }
            }
            updateDatabaseFromHeaders(state, innerState);
            checkConnectivity(state);
        } catch (DownloaderService.GenerateSaveFileError e2) {
            throw new StopRequest(e2.mStatus, e2.mMessage);
        }
    }

    private int readFromResponse(State state, InnerState innerState, byte[] bArr, InputStream inputStream) throws StopRequest {
        try {
            return inputStream.read(bArr);
        } catch (IOException e) {
            logNetworkState();
            this.mInfo.mCurrentBytes = innerState.mBytesSoFar;
            this.mDB.updateDownload(this.mInfo);
            if (cannotResume(innerState)) {
                throw new StopRequest(489, "while reading response: " + e.toString() + ", can't resume interrupted download with no ETag", e);
            }
            throw new StopRequest(getFinalStatusForHttpError(state), "while reading response: " + e.toString(), e);
        }
    }

    private void readResponseHeaders(State state, InnerState innerState, HttpResponse httpResponse) throws StopRequest {
        Header firstHeader;
        Header firstHeader2 = httpResponse.getFirstHeader("Content-Disposition");
        if (firstHeader2 != null) {
            innerState.mHeaderContentDisposition = firstHeader2.getValue();
        }
        Header firstHeader3 = httpResponse.getFirstHeader(HttpHeaders.CONTENT_LOCATION);
        if (firstHeader3 != null) {
            innerState.mHeaderContentLocation = firstHeader3.getValue();
        }
        Header firstHeader4 = httpResponse.getFirstHeader(HttpHeaders.ETAG);
        if (firstHeader4 != null) {
            innerState.mHeaderETag = firstHeader4.getValue();
        }
        Header firstHeader5 = httpResponse.getFirstHeader("Transfer-Encoding");
        String value = firstHeader5 != null ? firstHeader5.getValue() : null;
        Header firstHeader6 = httpResponse.getFirstHeader("Content-Type");
        if (firstHeader6 != null && !firstHeader6.getValue().equals("application/vnd.android.obb")) {
            throw new StopRequest(DownloaderService.STATUS_FILE_DELIVERED_INCORRECTLY, "file delivered with incorrect Mime type");
        }
        if (value == null && (firstHeader = httpResponse.getFirstHeader("Content-Length")) != null) {
            innerState.mHeaderContentLength = firstHeader.getValue();
            long parseLong = Long.parseLong(innerState.mHeaderContentLength);
            if (parseLong != -1 && parseLong != this.mInfo.mTotalBytes) {
                Log.e(Constants.TAG, "Incorrect file size delivered.");
            }
        }
        if (innerState.mHeaderContentLength == null) {
            if (value == null || !value.equalsIgnoreCase("chunked")) {
                throw new StopRequest(495, "can't know size of download, giving up");
            }
        }
    }

    private void reportProgress(State state, InnerState innerState) {
        long currentTimeMillis = System.currentTimeMillis();
        if (innerState.mBytesSoFar - innerState.mBytesNotified <= 4096 || currentTimeMillis - innerState.mTimeLastNotification <= 1000) {
            return;
        }
        this.mInfo.mCurrentBytes = innerState.mBytesSoFar;
        this.mDB.updateDownloadCurrentBytes(this.mInfo);
        innerState.mBytesNotified = innerState.mBytesSoFar;
        innerState.mTimeLastNotification = currentTimeMillis;
        this.mService.notifyUpdateBytes(innerState.mBytesThisSession + this.mService.mBytesSoFar);
    }

    private HttpResponse sendRequest(State state, AndroidHttpClient androidHttpClient, HttpGet httpGet) throws StopRequest {
        try {
            return androidHttpClient.execute(httpGet);
        } catch (IOException e) {
            logNetworkState();
            throw new StopRequest(getFinalStatusForHttpError(state), "while trying to execute request: " + e.toString(), e);
        } catch (IllegalArgumentException e2) {
            throw new StopRequest(495, "while trying to execute request: " + e2.toString(), e2);
        }
    }

    private void setupDestinationFile(State state, InnerState innerState) throws StopRequest {
        if (state.mFilename != null) {
            if (!Helpers.isFilenameValid(state.mFilename)) {
                throw new StopRequest(492, "found invalid internal destination filename");
            }
            File file = new File(state.mFilename);
            if (file.exists()) {
                long length = file.length();
                if (length == 0) {
                    file.delete();
                    state.mFilename = null;
                } else if (this.mInfo.mETag == null) {
                    file.delete();
                    throw new StopRequest(489, "Trying to resume a download that can't be resumed");
                } else {
                    try {
                        state.mStream = new FileOutputStream(state.mFilename, true);
                        innerState.mBytesSoFar = (int) length;
                        if (this.mInfo.mTotalBytes != -1) {
                            innerState.mHeaderContentLength = Long.toString(this.mInfo.mTotalBytes);
                        }
                        innerState.mHeaderETag = this.mInfo.mETag;
                        innerState.mContinuingDownload = true;
                    } catch (FileNotFoundException e) {
                        throw new StopRequest(492, "while opening destination for resuming: " + e.toString(), e);
                    }
                }
            }
        }
        if (state.mStream != null) {
            closeDestination(state);
        }
    }

    private void syncDestination(State state) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(state.mFilename, true);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
        } catch (FileNotFoundException e) {
            e = e;
        } catch (SyncFailedException e2) {
            e = e2;
        } catch (IOException e3) {
            e = e3;
        } catch (RuntimeException e4) {
            e = e4;
        }
        try {
            fileOutputStream.getFD().sync();
            try {
                fileOutputStream.close();
            } catch (IOException e5) {
                Log.w(Constants.TAG, "IOException while closing synced file: ", e5);
            } catch (RuntimeException e6) {
                Log.w(Constants.TAG, "exception while closing file: ", e6);
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            fileOutputStream2 = fileOutputStream;
            Log.w(Constants.TAG, "file " + state.mFilename + " not found: " + e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e8) {
                    Log.w(Constants.TAG, "IOException while closing synced file: ", e8);
                } catch (RuntimeException e9) {
                    Log.w(Constants.TAG, "exception while closing file: ", e9);
                }
            }
        } catch (SyncFailedException e10) {
            e = e10;
            fileOutputStream2 = fileOutputStream;
            Log.w(Constants.TAG, "file " + state.mFilename + " sync failed: " + e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e11) {
                    Log.w(Constants.TAG, "IOException while closing synced file: ", e11);
                } catch (RuntimeException e12) {
                    Log.w(Constants.TAG, "exception while closing file: ", e12);
                }
            }
        } catch (IOException e13) {
            e = e13;
            fileOutputStream2 = fileOutputStream;
            Log.w(Constants.TAG, "IOException trying to sync " + state.mFilename + ": " + e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e14) {
                    Log.w(Constants.TAG, "IOException while closing synced file: ", e14);
                } catch (RuntimeException e15) {
                    Log.w(Constants.TAG, "exception while closing file: ", e15);
                }
            }
        } catch (RuntimeException e16) {
            e = e16;
            fileOutputStream2 = fileOutputStream;
            Log.w(Constants.TAG, "exception while syncing file: ", e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e17) {
                    Log.w(Constants.TAG, "IOException while closing synced file: ", e17);
                } catch (RuntimeException e18) {
                    Log.w(Constants.TAG, "exception while closing file: ", e18);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e19) {
                    Log.w(Constants.TAG, "IOException while closing synced file: ", e19);
                } catch (RuntimeException e20) {
                    Log.w(Constants.TAG, "exception while closing file: ", e20);
                }
            }
            throw th;
        }
    }

    private void transferData(State state, InnerState innerState, byte[] bArr, InputStream inputStream) throws StopRequest {
        while (true) {
            int readFromResponse = readFromResponse(state, innerState, bArr, inputStream);
            if (readFromResponse == -1) {
                handleEndOfStream(state, innerState);
                return;
            }
            state.mGotData = true;
            writeDataToDestination(state, bArr, readFromResponse);
            innerState.mBytesSoFar += readFromResponse;
            innerState.mBytesThisSession += readFromResponse;
            reportProgress(state, innerState);
            checkPausedOrCanceled(state);
        }
    }

    private void updateDatabaseFromHeaders(State state, InnerState innerState) {
        this.mInfo.mETag = innerState.mHeaderETag;
        this.mDB.updateDownload(this.mInfo);
    }

    private void updateDownloadDatabase(int i, boolean z, int i2, int i3, boolean z2, String str) {
        this.mInfo.mStatus = i;
        this.mInfo.mRetryAfter = i2;
        this.mInfo.mRedirectCount = i3;
        this.mInfo.mLastMod = System.currentTimeMillis();
        if (z) {
            DownloadInfo downloadInfo = this.mInfo;
            if (z2) {
                downloadInfo.mNumFailed = 1;
            } else {
                downloadInfo.mNumFailed++;
            }
        } else {
            this.mInfo.mNumFailed = 0;
        }
        this.mDB.updateDownload(this.mInfo);
    }

    private String userAgent() {
        return this.mUserAgent;
    }

    private void writeDataToDestination(State state, byte[] bArr, int i) throws StopRequest {
        try {
            if (state.mStream == null) {
                state.mStream = new FileOutputStream(state.mFilename, true);
            }
            state.mStream.write(bArr, 0, i);
            closeDestination(state);
        } catch (IOException e) {
            if (!Helpers.isExternalMediaMounted()) {
                throw new StopRequest(499, "external media not mounted while writing destination file");
            }
            if (Helpers.getAvailableBytes(Helpers.getFilesystemRoot(state.mFilename)) >= i) {
                throw new StopRequest(492, "while writing destination file: " + e.toString(), e);
            }
            throw new StopRequest(498, "insufficient space while writing destination file", e);
        }
    }

    public HttpHost getPreferredHttpHost(Context context, String str) {
        String host;
        if (isLocalHost(str) || this.mService.isWiFi() || (host = Proxy.getHost(context)) == null) {
            return null;
        }
        return new HttpHost(host, Proxy.getPort(context), "http");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v9 */
    public void run() {
        PowerManager.WakeLock wakeLock;
        boolean z;
        int i;
        String str;
        int i2;
        Process.setThreadPriority(10);
        State state = new State(this.mInfo, this.mService);
        int i3 = 491;
        boolean z2 = 0;
        try {
            try {
                wakeLock = ((PowerManager) this.mContext.getSystemService("power")).newWakeLock(1, Constants.TAG);
                try {
                    wakeLock.acquire();
                    AndroidHttpClient newInstance = AndroidHttpClient.newInstance(userAgent(), this.mContext);
                    boolean z3 = false;
                    while (!z3) {
                        ConnRouteParams.setDefaultProxy(newInstance.getParams(), getPreferredHttpHost(this.mContext, state.mRequestUri));
                        HttpGet httpGet = new HttpGet(state.mRequestUri);
                        try {
                            executeDownload(state, newInstance, httpGet);
                            httpGet.abort();
                            z3 = true;
                        } catch (RetryDownload unused) {
                            httpGet.abort();
                        } catch (Throwable th) {
                            httpGet.abort();
                            throw th;
                        }
                    }
                    finalizeDestinationFile(state);
                    if (wakeLock != null) {
                        wakeLock.release();
                    }
                    if (newInstance != null) {
                        newInstance.close();
                    }
                    cleanupDestination(state, 200);
                    z = state.mCountRetry;
                    i = state.mRetryAfter;
                    i3 = state.mRedirectCount;
                    z2 = state.mGotData;
                    str = state.mFilename;
                    i2 = 200;
                } catch (StopRequest e) {
                    e = e;
                    Log.w(Constants.TAG, "Aborting request for download " + this.mInfo.mFileName + ": " + e.getMessage());
                    e.printStackTrace();
                    i2 = e.mFinalStatus;
                    if (wakeLock != null) {
                        wakeLock.release();
                    }
                    if (0 != 0) {
                        z2.close();
                    }
                    cleanupDestination(state, i2);
                    z = state.mCountRetry;
                    i = state.mRetryAfter;
                    i3 = state.mRedirectCount;
                    boolean z4 = state.mGotData;
                    str = state.mFilename;
                    z2 = z4;
                    notifyDownloadCompleted(i2, z, i, i3, z2, str);
                } catch (Throwable th2) {
                    th = th2;
                    Log.w(Constants.TAG, "Exception for " + this.mInfo.mFileName + ": " + th);
                    if (wakeLock != null) {
                        wakeLock.release();
                    }
                    if (0 != 0) {
                        z2.close();
                    }
                    cleanupDestination(state, 491);
                    z = state.mCountRetry;
                    i = state.mRetryAfter;
                    i3 = state.mRedirectCount;
                    boolean z5 = state.mGotData;
                    str = state.mFilename;
                    i2 = 491;
                    z2 = z5;
                    notifyDownloadCompleted(i2, z, i, i3, z2, str);
                }
            } catch (Throwable th3) {
                if (wakeLock != null) {
                    wakeLock.release();
                }
                if (z2 != 0) {
                    z2.close();
                }
                cleanupDestination(state, i3);
                notifyDownloadCompleted(491, state.mCountRetry, state.mRetryAfter, state.mRedirectCount, state.mGotData, state.mFilename);
                throw th3;
            }
        } catch (StopRequest e2) {
            e = e2;
            wakeLock = null;
        } catch (Throwable th4) {
            th = th4;
            wakeLock = null;
        }
        notifyDownloadCompleted(i2, z, i, i3, z2, str);
    }
}
