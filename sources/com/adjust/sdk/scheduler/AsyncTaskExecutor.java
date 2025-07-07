package com.adjust.sdk.scheduler;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public abstract class AsyncTaskExecutor<Params, Result> {
    public abstract Result doInBackground(Params[] paramsArr);

    @SafeVarargs
    public final AsyncTaskExecutor<Params, Result> execute(final Params... paramsArr) {
        onPreExecute();
        final Handler handler = new Handler(Looper.getMainLooper());
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.adjust.sdk.scheduler.AsyncTaskExecutor.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                final Object doInBackground = AsyncTaskExecutor.this.doInBackground(paramsArr);
                handler.post(new Runnable() { // from class: com.adjust.sdk.scheduler.AsyncTaskExecutor.1.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public final void run() {
                        AsyncTaskExecutor.this.onPostExecute(doInBackground);
                    }
                });
            }
        });
        return this;
    }

    public void onPostExecute(Result result) {
    }

    public void onPreExecute() {
    }
}
