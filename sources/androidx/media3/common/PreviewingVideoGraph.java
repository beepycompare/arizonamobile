package androidx.media3.common;

import android.content.Context;
import androidx.media3.common.VideoGraph;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public interface PreviewingVideoGraph extends VideoGraph {

    /* loaded from: classes2.dex */
    public interface Factory {
        PreviewingVideoGraph create(Context context, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, VideoCompositorSettings videoCompositorSettings, List<Effect> list, long j) throws VideoFrameProcessingException;

        boolean supportsMultipleInputs();
    }

    void renderOutputFrame(long j);
}
