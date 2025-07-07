package com.google.android.vending.expansion.downloader.impl;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Messenger;
import com.google.android.vending.expansion.downloader.DownloadProgressInfo;
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import com.google.android.vending.expansion.downloader.Helpers;
import com.google.android.vending.expansion.downloader.IDownloaderClient;
/* loaded from: classes4.dex */
public class DownloadNotification implements IDownloaderClient {
    static final String LOGTAG = "DownloadNotification";
    static final int NOTIFICATION_ID = LOGTAG.hashCode();
    private IDownloaderClient mClientProxy;
    private PendingIntent mContentIntent;
    private final Context mContext;
    private Notification.Builder mCurrentNotificationBuilder;
    private String mCurrentText;
    private String mCurrentTitle;
    private CharSequence mLabel;
    private Notification.Builder mNotificationBuilder;
    private final NotificationManager mNotificationManager;
    private DownloadProgressInfo mProgressInfo;
    private int mState = -1;
    final ICustomNotification mCustomNotification = CustomNotificationFactory.createCustomNotification();

    /* loaded from: classes4.dex */
    public interface ICustomNotification {
        void setCurrentBytes(long j);

        void setIcon(int i);

        void setPendingIntent(PendingIntent pendingIntent);

        void setTicker(CharSequence charSequence);

        void setTimeRemaining(long j);

        void setTitle(CharSequence charSequence);

        void setTotalBytes(long j);

        Notification.Builder updateNotification(Context context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DownloadNotification(Context context, CharSequence charSequence) {
        this.mContext = context;
        this.mLabel = charSequence;
        this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
        Notification.Builder builder = new Notification.Builder(context);
        this.mNotificationBuilder = builder;
        this.mCurrentNotificationBuilder = builder;
    }

    public PendingIntent getClientIntent() {
        return this.mContentIntent;
    }

    @Override // com.google.android.vending.expansion.downloader.IDownloaderClient
    public void onDownloadProgress(DownloadProgressInfo downloadProgressInfo) {
        Notification.Builder updateNotification;
        this.mProgressInfo = downloadProgressInfo;
        IDownloaderClient iDownloaderClient = this.mClientProxy;
        if (iDownloaderClient != null) {
            iDownloaderClient.onDownloadProgress(downloadProgressInfo);
        }
        if (downloadProgressInfo.mOverallTotal <= 0) {
            this.mNotificationBuilder.setTicker(this.mCurrentTitle);
            this.mNotificationBuilder.setSmallIcon(17301633);
            this.mNotificationBuilder.setContentTitle(this.mCurrentTitle);
            this.mNotificationBuilder.setContentText(this.mCurrentText);
            this.mNotificationBuilder.setContentIntent(this.mContentIntent);
            updateNotification = this.mNotificationBuilder;
        } else {
            this.mCustomNotification.setCurrentBytes(downloadProgressInfo.mOverallProgress);
            this.mCustomNotification.setTotalBytes(downloadProgressInfo.mOverallTotal);
            this.mCustomNotification.setIcon(17301633);
            this.mCustomNotification.setPendingIntent(this.mContentIntent);
            this.mCustomNotification.setTicker(((Object) this.mLabel) + ": " + this.mCurrentText);
            this.mCustomNotification.setTitle(this.mLabel);
            this.mCustomNotification.setTimeRemaining(downloadProgressInfo.mTimeRemaining);
            updateNotification = this.mCustomNotification.updateNotification(this.mContext);
        }
        this.mCurrentNotificationBuilder = updateNotification;
        this.mNotificationManager.notify(NOTIFICATION_ID, this.mCurrentNotificationBuilder.build());
    }

    @Override // com.google.android.vending.expansion.downloader.IDownloaderClient
    public void onDownloadStateChanged(int i) {
        int downloaderStringResourceIDFromState;
        IDownloaderClient iDownloaderClient = this.mClientProxy;
        if (iDownloaderClient != null) {
            iDownloaderClient.onDownloadStateChanged(i);
        }
        if (i != this.mState) {
            this.mState = i;
            if (i == 1 || this.mContentIntent == null) {
                return;
            }
            boolean z = false;
            int i2 = 17301642;
            if (i != 0) {
                if (i != 7) {
                    if (i == 2 || i == 3) {
                        downloaderStringResourceIDFromState = Helpers.getDownloaderStringResourceIDFromState(this.mContext, i);
                        z = true;
                        i2 = 17301634;
                        this.mCurrentText = this.mContext.getString(downloaderStringResourceIDFromState);
                        this.mCurrentTitle = this.mLabel.toString();
                        this.mCurrentNotificationBuilder.setTicker(((Object) this.mLabel) + ": " + this.mCurrentText);
                        this.mCurrentNotificationBuilder.setSmallIcon(i2);
                        this.mCurrentNotificationBuilder.setContentTitle(this.mCurrentTitle);
                        this.mCurrentNotificationBuilder.setContentText(this.mCurrentText);
                        this.mCurrentNotificationBuilder.setContentIntent(this.mContentIntent);
                        this.mCurrentNotificationBuilder.setOngoing(z);
                        this.mCurrentNotificationBuilder.setAutoCancel(true ^ z);
                        this.mNotificationManager.notify(NOTIFICATION_ID, this.mCurrentNotificationBuilder.build());
                    }
                    if (i == 4) {
                        downloaderStringResourceIDFromState = Helpers.getDownloaderStringResourceIDFromState(this.mContext, i);
                        i2 = 17301633;
                    } else if (i != 5) {
                        switch (i) {
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                                break;
                            default:
                                downloaderStringResourceIDFromState = Helpers.getDownloaderStringResourceIDFromState(this.mContext, i);
                                break;
                        }
                        this.mCurrentText = this.mContext.getString(downloaderStringResourceIDFromState);
                        this.mCurrentTitle = this.mLabel.toString();
                        this.mCurrentNotificationBuilder.setTicker(((Object) this.mLabel) + ": " + this.mCurrentText);
                        this.mCurrentNotificationBuilder.setSmallIcon(i2);
                        this.mCurrentNotificationBuilder.setContentTitle(this.mCurrentTitle);
                        this.mCurrentNotificationBuilder.setContentText(this.mCurrentText);
                        this.mCurrentNotificationBuilder.setContentIntent(this.mContentIntent);
                        this.mCurrentNotificationBuilder.setOngoing(z);
                        this.mCurrentNotificationBuilder.setAutoCancel(true ^ z);
                        this.mNotificationManager.notify(NOTIFICATION_ID, this.mCurrentNotificationBuilder.build());
                    }
                    z = true;
                    this.mCurrentText = this.mContext.getString(downloaderStringResourceIDFromState);
                    this.mCurrentTitle = this.mLabel.toString();
                    this.mCurrentNotificationBuilder.setTicker(((Object) this.mLabel) + ": " + this.mCurrentText);
                    this.mCurrentNotificationBuilder.setSmallIcon(i2);
                    this.mCurrentNotificationBuilder.setContentTitle(this.mCurrentTitle);
                    this.mCurrentNotificationBuilder.setContentText(this.mCurrentText);
                    this.mCurrentNotificationBuilder.setContentIntent(this.mContentIntent);
                    this.mCurrentNotificationBuilder.setOngoing(z);
                    this.mCurrentNotificationBuilder.setAutoCancel(true ^ z);
                    this.mNotificationManager.notify(NOTIFICATION_ID, this.mCurrentNotificationBuilder.build());
                }
                downloaderStringResourceIDFromState = Helpers.getDownloaderStringResourceIDFromState(this.mContext, i);
                i2 = 17301634;
                this.mCurrentText = this.mContext.getString(downloaderStringResourceIDFromState);
                this.mCurrentTitle = this.mLabel.toString();
                this.mCurrentNotificationBuilder.setTicker(((Object) this.mLabel) + ": " + this.mCurrentText);
                this.mCurrentNotificationBuilder.setSmallIcon(i2);
                this.mCurrentNotificationBuilder.setContentTitle(this.mCurrentTitle);
                this.mCurrentNotificationBuilder.setContentText(this.mCurrentText);
                this.mCurrentNotificationBuilder.setContentIntent(this.mContentIntent);
                this.mCurrentNotificationBuilder.setOngoing(z);
                this.mCurrentNotificationBuilder.setAutoCancel(true ^ z);
                this.mNotificationManager.notify(NOTIFICATION_ID, this.mCurrentNotificationBuilder.build());
            }
            downloaderStringResourceIDFromState = Helpers.getDownloaderStringResourceIDFromState(this.mContext, i);
            this.mCurrentText = this.mContext.getString(downloaderStringResourceIDFromState);
            this.mCurrentTitle = this.mLabel.toString();
            this.mCurrentNotificationBuilder.setTicker(((Object) this.mLabel) + ": " + this.mCurrentText);
            this.mCurrentNotificationBuilder.setSmallIcon(i2);
            this.mCurrentNotificationBuilder.setContentTitle(this.mCurrentTitle);
            this.mCurrentNotificationBuilder.setContentText(this.mCurrentText);
            this.mCurrentNotificationBuilder.setContentIntent(this.mContentIntent);
            this.mCurrentNotificationBuilder.setOngoing(z);
            this.mCurrentNotificationBuilder.setAutoCancel(true ^ z);
            this.mNotificationManager.notify(NOTIFICATION_ID, this.mCurrentNotificationBuilder.build());
        }
    }

    @Override // com.google.android.vending.expansion.downloader.IDownloaderClient
    public void onServiceConnected(Messenger messenger) {
    }

    public void resendState() {
        IDownloaderClient iDownloaderClient = this.mClientProxy;
        if (iDownloaderClient != null) {
            iDownloaderClient.onDownloadStateChanged(this.mState);
        }
    }

    public void setClientIntent(PendingIntent pendingIntent) {
        this.mContentIntent = pendingIntent;
    }

    public void setMessenger(Messenger messenger) {
        IDownloaderClient CreateProxy = DownloaderClientMarshaller.CreateProxy(messenger);
        this.mClientProxy = CreateProxy;
        DownloadProgressInfo downloadProgressInfo = this.mProgressInfo;
        if (downloadProgressInfo != null) {
            CreateProxy.onDownloadProgress(downloadProgressInfo);
        }
        int i = this.mState;
        if (i != -1) {
            this.mClientProxy.onDownloadStateChanged(i);
        }
    }
}
