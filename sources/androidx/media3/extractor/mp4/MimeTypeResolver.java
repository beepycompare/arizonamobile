package androidx.media3.extractor.mp4;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import java.util.List;
import java.util.Objects;
/* loaded from: classes2.dex */
final class MimeTypeResolver {
    public static String getContainerMimeType(Format format) {
        String str = format.sampleMimeType;
        if (MimeTypes.isVideo(str)) {
            return MimeTypes.VIDEO_MP4;
        }
        if (MimeTypes.isAudio(str)) {
            return MimeTypes.AUDIO_MP4;
        }
        if (MimeTypes.isImage(str)) {
            if (Objects.equals(str, "image/heic")) {
                return "image/heif";
            }
            if (Objects.equals(str, MimeTypes.IMAGE_AVIF)) {
                return MimeTypes.IMAGE_AVIF;
            }
            return MimeTypes.APPLICATION_MP4;
        }
        return MimeTypes.APPLICATION_MP4;
    }

    public static String getContainerMimeType(List<TrackSampleTable> list) {
        boolean z = false;
        String str = null;
        for (TrackSampleTable trackSampleTable : list) {
            String str2 = trackSampleTable.track.format.sampleMimeType;
            if (MimeTypes.isVideo(str2)) {
                return MimeTypes.VIDEO_MP4;
            }
            if (MimeTypes.isAudio(str2)) {
                z = true;
            } else if (MimeTypes.isImage(str2)) {
                if (Objects.equals(str2, "image/heic")) {
                    str = "image/heif";
                } else if (Objects.equals(str2, MimeTypes.IMAGE_AVIF)) {
                    str = MimeTypes.IMAGE_AVIF;
                }
            }
        }
        if (z) {
            return MimeTypes.AUDIO_MP4;
        }
        return str != null ? str : MimeTypes.APPLICATION_MP4;
    }

    private MimeTypeResolver() {
    }
}
