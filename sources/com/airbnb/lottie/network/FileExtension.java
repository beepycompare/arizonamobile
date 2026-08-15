package com.airbnb.lottie.network;

import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
/* loaded from: classes3.dex */
public enum FileExtension {
    JSON(".json"),
    ZIP(OriginalTzArchiveManifestParser.ZIP_SUFFIX),
    GZIP(".gz");
    
    public final String extension;

    FileExtension(String str) {
        this.extension = str;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
