package androidx.media3.exoplayer.trackselection;

import android.graphics.Point;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public final class TrackSelectionUtil {

    /* loaded from: classes3.dex */
    public interface AdaptiveTrackSelectionFactory {
        ExoTrackSelection createAdaptiveTrackSelection(ExoTrackSelection.Definition definition);
    }

    private TrackSelectionUtil() {
    }

    public static ExoTrackSelection[] createTrackSelectionsForDefinitions(ExoTrackSelection.Definition[] definitionArr, AdaptiveTrackSelectionFactory adaptiveTrackSelectionFactory) {
        ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
        boolean z = false;
        for (int i = 0; i < definitionArr.length; i++) {
            ExoTrackSelection.Definition definition = definitionArr[i];
            if (definition != null) {
                if (definition.tracks.length > 1 && !z) {
                    exoTrackSelectionArr[i] = adaptiveTrackSelectionFactory.createAdaptiveTrackSelection(definition);
                    z = true;
                } else {
                    exoTrackSelectionArr[i] = new FixedTrackSelection(definition.group, definition.tracks[0], definition.type);
                }
            }
        }
        return exoTrackSelectionArr;
    }

    @Deprecated
    public static DefaultTrackSelector.Parameters updateParametersWithOverride(DefaultTrackSelector.Parameters parameters, int i, TrackGroupArray trackGroupArray, boolean z, DefaultTrackSelector.SelectionOverride selectionOverride) {
        DefaultTrackSelector.Parameters.Builder rendererDisabled = parameters.buildUpon().clearSelectionOverrides(i).setRendererDisabled(i, z);
        if (selectionOverride != null) {
            rendererDisabled.setSelectionOverride(i, trackGroupArray, selectionOverride);
        }
        return rendererDisabled.build();
    }

    public static Tracks buildTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, TrackSelection[] trackSelectionArr) {
        List[] listArr = new List[trackSelectionArr.length];
        for (int i = 0; i < trackSelectionArr.length; i++) {
            TrackSelection trackSelection = trackSelectionArr[i];
            listArr[i] = trackSelection != null ? ImmutableList.of(trackSelection) : ImmutableList.of();
        }
        return buildTracks(mappedTrackInfo, listArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /* JADX WARN: Type inference failed for: r3v14 */
    public static Tracks buildTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, List<? extends TrackSelection>[] listArr) {
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2 = mappedTrackInfo;
        List<? extends TrackSelection>[] listArr2 = listArr;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        boolean z = false;
        int i = 0;
        while (i < mappedTrackInfo2.getRendererCount()) {
            TrackGroupArray trackGroups = mappedTrackInfo2.getTrackGroups(i);
            int i2 = z;
            while (i2 < trackGroups.length) {
                TrackGroup trackGroup = trackGroups.get(i2);
                boolean z2 = mappedTrackInfo2.getAdaptiveSupport(i, i2, z) != 0 ? true : z;
                int[] iArr = new int[trackGroup.length];
                boolean[] zArr = new boolean[trackGroup.length];
                MappingTrackSelector.MappedTrackInfo mappedTrackInfo3 = mappedTrackInfo2;
                for (int i3 = z; i3 < trackGroup.length; i3++) {
                    iArr[i3] = mappedTrackInfo3.getTrackSupport(i, i2, i3);
                    int length = listArr2.length;
                    boolean z3 = z;
                    boolean z4 = z3;
                    boolean z5 = z;
                    for (int i4 = z3; i4 < length; i4++) {
                        List<? extends TrackSelection> list = listArr2[i4];
                        int i5 = z5;
                        while (true) {
                            if (i5 < list.size()) {
                                TrackSelection trackSelection = list.get(i5);
                                if (trackSelection.getTrackGroup().equals(trackGroup) && trackSelection.indexOf(i3) != -1) {
                                    z4 = true;
                                    break;
                                }
                                i5++;
                            }
                        }
                        listArr2 = listArr;
                        z5 = false;
                    }
                    zArr[i3] = z4;
                    mappedTrackInfo3 = mappedTrackInfo;
                    listArr2 = listArr;
                    z = false;
                }
                builder.add((ImmutableList.Builder) new Tracks.Group(trackGroup, z2, iArr, zArr));
                i2++;
                mappedTrackInfo2 = mappedTrackInfo;
                listArr2 = listArr;
                z = false;
            }
            i++;
            mappedTrackInfo2 = mappedTrackInfo;
            listArr2 = listArr;
            z = false;
        }
        TrackGroupArray unmappedTrackGroups = mappedTrackInfo.getUnmappedTrackGroups();
        for (int i6 = 0; i6 < unmappedTrackGroups.length; i6++) {
            TrackGroup trackGroup2 = unmappedTrackGroups.get(i6);
            int[] iArr2 = new int[trackGroup2.length];
            Arrays.fill(iArr2, 0);
            builder.add((ImmutableList.Builder) new Tracks.Group(trackGroup2, false, iArr2, new boolean[trackGroup2.length]));
        }
        return new Tracks(builder.build());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x000d, code lost:
        if ((r6 > r7) != (r4 > r5)) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Point getMaxVideoSizeInViewport(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
        }
        i2 = i;
        i = i2;
        int i5 = i3 * i;
        int i6 = i4 * i2;
        if (i5 >= i6) {
            return new Point(i2, Util.ceilDivide(i6, i3));
        }
        return new Point(Util.ceilDivide(i5, i4), i);
    }
}
