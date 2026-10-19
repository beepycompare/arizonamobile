package com.miami.game.core.settings.mods;

import android.system.Os;
import android.system.OsConstants;
import androidx.media3.extractor.text.ttml.TtmlNode;
import coil3.util.UtilsKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ModsManifestStore.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0003\f\r\u000eB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/miami/game/core/settings/mods/ModsManifestStore;", "", "io", "Lcom/miami/game/core/settings/mods/ModsManifestStore$Operations;", "<init>", "(Lcom/miami/game/core/settings/mods/ModsManifestStore$Operations;)V", "publish", "", "root", "Ljava/io/File;", "bytes", "", "Operations", "SystemOperations", "Companion", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModsManifestStore {
    public static final Companion Companion = new Companion(null);

    /* renamed from: io  reason: collision with root package name */
    private final Operations f209io;

    /* compiled from: ModsManifestStore.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/miami/game/core/settings/mods/ModsManifestStore$Operations;", "", TtmlNode.TEXT_EMPHASIS_MARK_OPEN, "Ljava/io/FileOutputStream;", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "sync", "", "stream", "syncDirectory", "directory", "replace", "source", FirebaseAnalytics.Param.DESTINATION, "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Operations {
        FileOutputStream open(File file);

        void replace(File file, File file2);

        void sync(FileOutputStream fileOutputStream);

        void syncDirectory(File file);
    }

    public ModsManifestStore() {
        this(null, 1, null);
    }

    public ModsManifestStore(Operations io2) {
        Intrinsics.checkNotNullParameter(io2, "io");
        this.f209io = io2;
    }

    public /* synthetic */ ModsManifestStore(SystemOperations systemOperations, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SystemOperations.INSTANCE : systemOperations);
    }

    public final void publish(File root, byte[] bytes) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        File file = new File(root, "manifest.json");
        File createTempFile = File.createTempFile("manifest-", ".tmp", root);
        try {
            Operations operations = this.f209io;
            Intrinsics.checkNotNull(createTempFile);
            FileOutputStream open = operations.open(createTempFile);
            FileOutputStream fileOutputStream = open;
            fileOutputStream.write(bytes);
            this.f209io.sync(fileOutputStream);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(open, null);
            this.f209io.syncDirectory(new File(root, "objects"));
            this.f209io.replace(createTempFile, file);
            this.f209io.syncDirectory(root);
        } finally {
            createTempFile.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ModsManifestStore.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¨\u0006\u0010"}, d2 = {"Lcom/miami/game/core/settings/mods/ModsManifestStore$SystemOperations;", "Lcom/miami/game/core/settings/mods/ModsManifestStore$Operations;", "<init>", "()V", TtmlNode.TEXT_EMPHASIS_MARK_OPEN, "Ljava/io/FileOutputStream;", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "sync", "", "stream", "syncDirectory", "directory", "replace", "source", FirebaseAnalytics.Param.DESTINATION, "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class SystemOperations implements Operations {
        public static final SystemOperations INSTANCE = new SystemOperations();

        private SystemOperations() {
        }

        @Override // com.miami.game.core.settings.mods.ModsManifestStore.Operations
        public FileOutputStream open(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new FileOutputStream(file);
        }

        @Override // com.miami.game.core.settings.mods.ModsManifestStore.Operations
        public void sync(FileOutputStream stream) {
            Intrinsics.checkNotNullParameter(stream, "stream");
            stream.getFD().sync();
        }

        @Override // com.miami.game.core.settings.mods.ModsManifestStore.Operations
        public void syncDirectory(File directory) {
            Intrinsics.checkNotNullParameter(directory, "directory");
            ModsManifestStore.Companion.syncDirectory(directory);
        }

        @Override // com.miami.game.core.settings.mods.ModsManifestStore.Operations
        public void replace(File source, File destination) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(destination, "destination");
            Os.rename(source.getAbsolutePath(), destination.getAbsolutePath());
        }
    }

    /* compiled from: ModsManifestStore.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/settings/mods/ModsManifestStore$Companion;", "", "<init>", "()V", "syncDirectory", "", "directory", "Ljava/io/File;", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void syncDirectory(File directory) {
            Intrinsics.checkNotNullParameter(directory, "directory");
            FileDescriptor open = Os.open(directory.getAbsolutePath(), OsConstants.O_RDONLY, 0);
            try {
                Os.fsync(open);
            } finally {
                Os.close(open);
            }
        }
    }
}
