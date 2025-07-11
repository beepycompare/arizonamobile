package com.miami.game.core.files.updater.data;

import android.content.ContentResolver;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FilesUpdaterRepository.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/miami/game/core/files/updater/data/FilesUpdaterRepository;", "", "contentResolver", "Landroid/content/ContentResolver;", "<init>", "(Landroid/content/ContentResolver;)V", "files-updater_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FilesUpdaterRepository {
    private final ContentResolver contentResolver;

    @Inject
    public FilesUpdaterRepository(ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        this.contentResolver = contentResolver;
    }
}
