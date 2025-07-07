package com.google.android.vending.expansion.downloader;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
/* loaded from: classes4.dex */
public class DownloaderServiceMarshaller {
    public static final int MSG_REQUEST_ABORT_DOWNLOAD = 1;
    public static final int MSG_REQUEST_CLIENT_UPDATE = 6;
    public static final int MSG_REQUEST_CONTINUE_DOWNLOAD = 4;
    public static final int MSG_REQUEST_DOWNLOAD_STATE = 5;
    public static final int MSG_REQUEST_PAUSE_DOWNLOAD = 2;
    public static final int MSG_SET_DOWNLOAD_FLAGS = 3;
    public static final String PARAMS_FLAGS = "flags";
    public static final String PARAM_MESSENGER = "EMH";

    /* loaded from: classes4.dex */
    private static class Proxy implements IDownloaderService {
        private Messenger mMsg;

        public Proxy(Messenger messenger) {
            this.mMsg = messenger;
        }

        private void send(int i, Bundle bundle) {
            Message obtain = Message.obtain((Handler) null, i);
            obtain.setData(bundle);
            try {
                this.mMsg.send(obtain);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // com.google.android.vending.expansion.downloader.IDownloaderService
        public void onClientUpdated(Messenger messenger) {
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("EMH", messenger);
            send(6, bundle);
        }

        @Override // com.google.android.vending.expansion.downloader.IDownloaderService
        public void requestAbortDownload() {
            send(1, new Bundle());
        }

        @Override // com.google.android.vending.expansion.downloader.IDownloaderService
        public void requestContinueDownload() {
            send(4, new Bundle());
        }

        @Override // com.google.android.vending.expansion.downloader.IDownloaderService
        public void requestDownloadStatus() {
            send(5, new Bundle());
        }

        @Override // com.google.android.vending.expansion.downloader.IDownloaderService
        public void requestPauseDownload() {
            send(2, new Bundle());
        }

        @Override // com.google.android.vending.expansion.downloader.IDownloaderService
        public void setDownloadFlags(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt(DownloaderServiceMarshaller.PARAMS_FLAGS, i);
            send(3, bundle);
        }
    }

    /* loaded from: classes4.dex */
    private static class Stub implements IStub {
        private IDownloaderService mItf;
        final Messenger mMessenger = new Messenger(new Handler() { // from class: com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller.Stub.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        Stub.this.mItf.requestAbortDownload();
                        return;
                    case 2:
                        Stub.this.mItf.requestPauseDownload();
                        return;
                    case 3:
                        Stub.this.mItf.setDownloadFlags(message.getData().getInt(DownloaderServiceMarshaller.PARAMS_FLAGS));
                        return;
                    case 4:
                        Stub.this.mItf.requestContinueDownload();
                        return;
                    case 5:
                        Stub.this.mItf.requestDownloadStatus();
                        return;
                    case 6:
                        Stub.this.mItf.onClientUpdated((Messenger) message.getData().getParcelable("EMH"));
                        return;
                    default:
                        return;
                }
            }
        });

        public Stub(IDownloaderService iDownloaderService) {
            this.mItf = null;
            this.mItf = iDownloaderService;
        }

        @Override // com.google.android.vending.expansion.downloader.IStub
        public void connect(Context context) {
        }

        @Override // com.google.android.vending.expansion.downloader.IStub
        public void disconnect(Context context) {
        }

        @Override // com.google.android.vending.expansion.downloader.IStub
        public Messenger getMessenger() {
            return this.mMessenger;
        }
    }

    public static IDownloaderService CreateProxy(Messenger messenger) {
        return new Proxy(messenger);
    }

    public static IStub CreateStub(IDownloaderService iDownloaderService) {
        return new Stub(iDownloaderService);
    }
}
