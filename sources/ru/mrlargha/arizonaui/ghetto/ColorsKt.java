package ru.mrlargha.arizonaui.ghetto;

import kotlin.Metadata;
import ru.mrlargha.arizonaui.R;
/* compiled from: Colors.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0006"}, d2 = {"ghettoColors", "", "id", "", "ghettoImages", "ghettoNames", "ArizonaUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ColorsKt {
    public static final String ghettoColors(int i) {
        if (i != 25) {
            switch (i) {
                case 11:
                    return "#5D8836";
                case 12:
                    return "#DB9800";
                case 13:
                    return "#99389E";
                case 14:
                    return "#55A5B6";
                case 15:
                    return "#3766CD";
                default:
                    return "#818181";
            }
        }
        return "#6B6B6B";
    }

    public static final int ghettoImages(int i) {
        if (i != 25) {
            switch (i) {
                case 11:
                    return R.drawable.ghetto_band_1;
                case 12:
                    return R.drawable.ghetto_band_5;
                case 13:
                    return R.drawable.ghetto_band_4;
                case 14:
                    return R.drawable.ghetto_band_2;
                case 15:
                    return R.drawable.ghetto_band_3;
                default:
                    return R.drawable.ghetto_band_1;
            }
        }
        return R.drawable.ghetto_band_6;
    }

    public static final String ghettoNames(int i) {
        if (i != 25) {
            switch (i) {
                case 11:
                    return "Grove Street";
                case 12:
                    return "Los Santos Vagos";
                case 13:
                    return "East Side Ballas";
                case 14:
                    return "Varrios Los Aztecaz";
                case 15:
                    return "Rifa";
                default:
                    return "";
            }
        }
        return "Night Wolves";
    }
}
