package com.google.android.vending.expansion.downloader.impl;

import com.google.android.vending.expansion.downloader.Helpers;
/* loaded from: classes4.dex */
public class DownloadInfo {
    public int mControl;
    public long mCurrentBytes;
    public String mETag;
    public final String mFileName;
    public int mFuzz = Helpers.sRandom.nextInt(1001);
    public final int mIndex;
    boolean mInitialized;
    public long mLastMod;
    public int mNumFailed;
    public int mRedirectCount;
    public int mRetryAfter;
    public int mStatus;
    public long mTotalBytes;
    public String mUri;

    public DownloadInfo(int i, String str, String str2) {
        this.mFileName = str;
        this.mIndex = i;
    }

    public void resetDownload() {
        this.mCurrentBytes = 0L;
        this.mETag = "";
        this.mLastMod = 0L;
        this.mStatus = 0;
        this.mControl = 0;
        this.mNumFailed = 0;
        this.mRetryAfter = 0;
        this.mRedirectCount = 0;
    }
}
