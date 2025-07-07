package androidx.media3.extractor.metadata.id3;

import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class TextInformationFrame extends Id3Frame {
    public final String description;
    @Deprecated
    public final String value;
    public final ImmutableList<String> values;

    public TextInformationFrame(String str, String str2, List<String> list) {
        super(str);
        Assertions.checkArgument(!list.isEmpty());
        this.description = str2;
        ImmutableList<String> copyOf = ImmutableList.copyOf((Collection) list);
        this.values = copyOf;
        this.value = copyOf.get(0);
    }

    @Deprecated
    public TextInformationFrame(String str, String str2, String str3) {
        this(str, str2, ImmutableList.of(str3));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.media3.common.Metadata.Entry
    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.id;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    c = 0;
                    break;
                }
                break;
            case 82878:
                if (str.equals("TCM")) {
                    c = 1;
                    break;
                }
                break;
            case 82897:
                if (str.equals("TDA")) {
                    c = 2;
                    break;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    c = 3;
                    break;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    c = 4;
                    break;
                }
                break;
            case 83255:
                if (str.equals("TP3")) {
                    c = 5;
                    break;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    c = 6;
                    break;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    c = 7;
                    break;
                }
                break;
            case 83536:
                if (str.equals("TXT")) {
                    c = '\b';
                    break;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    c = '\t';
                    break;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    c = '\n';
                    break;
                }
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    c = 11;
                    break;
                }
                break;
            case 2569358:
                if (str.equals("TCON")) {
                    c = '\f';
                    break;
                }
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    c = '\r';
                    break;
                }
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    c = 14;
                    break;
                }
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    c = 15;
                    break;
                }
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    c = 16;
                    break;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    c = 17;
                    break;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    c = 18;
                    break;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    c = 19;
                    break;
                }
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    c = 20;
                    break;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    c = 21;
                    break;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    c = 22;
                    break;
                }
                break;
        }
        try {
            switch (c) {
                case 0:
                case '\n':
                    builder.setAlbumTitle(this.values.get(0));
                    return;
                case 1:
                case 11:
                    builder.setComposer(this.values.get(0));
                    return;
                case 2:
                case '\r':
                    String str2 = this.values.get(0);
                    builder.setRecordingMonth(Integer.valueOf(Integer.parseInt(str2.substring(2, 4)))).setRecordingDay(Integer.valueOf(Integer.parseInt(str2.substring(0, 2))));
                    return;
                case 3:
                case 18:
                    builder.setArtist(this.values.get(0));
                    return;
                case 4:
                case 19:
                    builder.setAlbumArtist(this.values.get(0));
                    return;
                case 5:
                case 20:
                    builder.setConductor(this.values.get(0));
                    return;
                case 6:
                case 21:
                    String[] split = Util.split(this.values.get(0), RemoteSettings.FORWARD_SLASH_STRING);
                    builder.setTrackNumber(Integer.valueOf(Integer.parseInt(split[0]))).setTotalTrackCount(split.length > 1 ? Integer.valueOf(Integer.parseInt(split[1])) : null);
                    return;
                case 7:
                case 17:
                    builder.setTitle(this.values.get(0));
                    return;
                case '\b':
                case 16:
                    builder.setWriter(this.values.get(0));
                    return;
                case '\t':
                case 22:
                    builder.setRecordingYear(Integer.valueOf(Integer.parseInt(this.values.get(0))));
                    return;
                case '\f':
                    Integer tryParse = Ints.tryParse(this.values.get(0));
                    if (tryParse == null) {
                        builder.setGenre(this.values.get(0));
                        return;
                    }
                    String resolveV1Genre = Id3Util.resolveV1Genre(tryParse.intValue());
                    if (resolveV1Genre != null) {
                        builder.setGenre(resolveV1Genre);
                        return;
                    }
                    return;
                case 14:
                    List<Integer> parseId3v2point4TimestampFrameForDate = parseId3v2point4TimestampFrameForDate(this.values.get(0));
                    int size = parseId3v2point4TimestampFrameForDate.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size != 3) {
                                return;
                            }
                            builder.setRecordingDay(parseId3v2point4TimestampFrameForDate.get(2));
                        }
                        builder.setRecordingMonth(parseId3v2point4TimestampFrameForDate.get(1));
                    }
                    builder.setRecordingYear(parseId3v2point4TimestampFrameForDate.get(0));
                    return;
                case 15:
                    List<Integer> parseId3v2point4TimestampFrameForDate2 = parseId3v2point4TimestampFrameForDate(this.values.get(0));
                    int size2 = parseId3v2point4TimestampFrameForDate2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 != 3) {
                                return;
                            }
                            builder.setReleaseDay(parseId3v2point4TimestampFrameForDate2.get(2));
                        }
                        builder.setReleaseMonth(parseId3v2point4TimestampFrameForDate2.get(1));
                    }
                    builder.setReleaseYear(parseId3v2point4TimestampFrameForDate2.get(0));
                    return;
                default:
                    return;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
            if (Objects.equals(this.id, textInformationFrame.id) && Objects.equals(this.description, textInformationFrame.description) && this.values.equals(textInformationFrame.values)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (527 + this.id.hashCode()) * 31;
        String str = this.description;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.values.hashCode();
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public String toString() {
        return this.id + ": description=" + this.description + ": values=" + this.values;
    }

    private static List<Integer> parseId3v2point4TimestampFrameForDate(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
                return arrayList;
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                return arrayList;
            } else {
                if (str.length() >= 4) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                }
                return arrayList;
            }
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }
}
