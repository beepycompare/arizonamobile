package com.liulishuo.okdownload.core.breakpoint;

import com.arizona.launcher.util.FileServers;
import com.liulishuo.okdownload.DownloadTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: LauncherKeyToIdMap.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014¨\u0006\b"}, d2 = {"Lcom/liulishuo/okdownload/core/breakpoint/LauncherKeyToIdMap;", "Lcom/liulishuo/okdownload/core/breakpoint/KeyToIdMap;", "<init>", "()V", "generateKey", "", "task", "Lcom/liulishuo/okdownload/DownloadTask;", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LauncherKeyToIdMap extends KeyToIdMap {
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.liulishuo.okdownload.core.breakpoint.KeyToIdMap
    public String generateKey(DownloadTask task) {
        String[] game_servers;
        Intrinsics.checkNotNullParameter(task, "task");
        for (String str : FileServers.INSTANCE.getGame_servers()) {
            String url = task.getUrl();
            Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
            if (StringsKt.startsWith$default(url, str, false, 2, (Object) null)) {
                String url2 = task.getUrl();
                Intrinsics.checkNotNullExpressionValue(url2, "getUrl(...)");
                return StringsKt.removePrefix(url2, (CharSequence) str) + task.getUri() + task.getFilename();
            }
        }
        String generateKey = super.generateKey(task);
        Intrinsics.checkNotNullExpressionValue(generateKey, "generateKey(...)");
        return generateKey;
    }
}
