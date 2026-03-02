package androidx.media3.extractor.text.subrip;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.media3.common.C;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.time.DurationKt;
/* loaded from: classes3.dex */
public final class SubripParser implements SubtitleParser {
    private static final String ALIGN_BOTTOM_LEFT = "{\\an1}";
    private static final String ALIGN_BOTTOM_MID = "{\\an2}";
    private static final String ALIGN_BOTTOM_RIGHT = "{\\an3}";
    private static final String ALIGN_MID_LEFT = "{\\an4}";
    private static final String ALIGN_MID_MID = "{\\an5}";
    private static final String ALIGN_MID_RIGHT = "{\\an6}";
    private static final String ALIGN_TOP_LEFT = "{\\an7}";
    private static final String ALIGN_TOP_MID = "{\\an8}";
    private static final String ALIGN_TOP_RIGHT = "{\\an9}";
    public static final int CUE_REPLACEMENT_BEHAVIOR = 1;
    private static final float END_FRACTION = 0.92f;
    private static final float MID_FRACTION = 0.5f;
    private static final float START_FRACTION = 0.08f;
    private static final String SUBRIP_ALIGNMENT_TAG = "\\{\\\\an[1-9]\\}";
    private static final String SUBRIP_TIMECODE = "(?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?";
    private static final String TAG = "SubripParser";
    private static final Pattern SUBRIP_TIMING_LINE = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*");
    private static final Pattern SUBRIP_TAG_PATTERN = Pattern.compile("\\{\\\\.*?\\}");
    private final StringBuilder textBuilder = new StringBuilder();
    private final ArrayList<String> tags = new ArrayList<>();
    private final ParsableByteArray parsableByteArray = new ParsableByteArray();

    @Override // androidx.media3.extractor.text.SubtitleParser
    public int getCueReplacementBehavior() {
        return 1;
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public void parse(byte[] bArr, int i, int i2, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        long j;
        String readLine;
        StringBuilder sb;
        String str;
        this.parsableByteArray.reset(bArr, i + i2);
        this.parsableByteArray.setPosition(i);
        Charset detectUtfCharset = detectUtfCharset(this.parsableByteArray);
        long j2 = outputOptions.startTimeUs;
        long j3 = C.TIME_UNSET;
        ArrayList<CuesWithTiming> arrayList = (j2 == C.TIME_UNSET || !outputOptions.outputAllCues) ? null : new ArrayList();
        while (true) {
            String readLine2 = this.parsableByteArray.readLine(detectUtfCharset);
            if (readLine2 == null) {
                break;
            } else if (!readLine2.isEmpty()) {
                try {
                    Integer.parseInt(readLine2);
                    readLine = this.parsableByteArray.readLine(detectUtfCharset);
                } catch (NumberFormatException unused) {
                    j = j3;
                    Log.w(TAG, "Skipping invalid index: " + readLine2);
                }
                if (readLine == null) {
                    Log.w(TAG, "Unexpected end");
                    break;
                }
                Matcher matcher = SUBRIP_TIMING_LINE.matcher(readLine);
                if (!matcher.matches()) {
                    j = j3;
                    Log.w(TAG, "Skipping invalid timing: " + readLine);
                } else {
                    long parseTimecode = parseTimecode(matcher, 1);
                    long parseTimecode2 = parseTimecode(matcher, 6);
                    int i3 = 0;
                    this.textBuilder.setLength(0);
                    this.tags.clear();
                    String readLine3 = this.parsableByteArray.readLine(detectUtfCharset);
                    while (true) {
                        boolean isEmpty = TextUtils.isEmpty(readLine3);
                        sb = this.textBuilder;
                        if (isEmpty) {
                            break;
                        }
                        if (sb.length() > 0) {
                            this.textBuilder.append("<br>");
                        }
                        this.textBuilder.append(processLine(readLine3, this.tags));
                        readLine3 = this.parsableByteArray.readLine(detectUtfCharset);
                    }
                    Spanned fromHtml = Html.fromHtml(sb.toString());
                    while (true) {
                        if (i3 >= this.tags.size()) {
                            str = null;
                            break;
                        }
                        str = this.tags.get(i3);
                        if (str.matches(SUBRIP_ALIGNMENT_TAG)) {
                            break;
                        }
                        i3++;
                    }
                    j = j3;
                    if (outputOptions.startTimeUs == j || parseTimecode2 >= outputOptions.startTimeUs) {
                        consumer.accept(new CuesWithTiming(ImmutableList.of(buildCue(fromHtml, str)), parseTimecode, parseTimecode2 - parseTimecode));
                    } else if (arrayList != null) {
                        arrayList.add(new CuesWithTiming(ImmutableList.of(buildCue(fromHtml, str)), parseTimecode, parseTimecode2 - parseTimecode));
                    }
                }
                j3 = j;
            }
        }
        if (arrayList != null) {
            for (CuesWithTiming cuesWithTiming : arrayList) {
                consumer.accept(cuesWithTiming);
            }
        }
    }

    private Charset detectUtfCharset(ParsableByteArray parsableByteArray) {
        Charset readUtfCharsetFromBom = parsableByteArray.readUtfCharsetFromBom();
        return readUtfCharsetFromBom != null ? readUtfCharsetFromBom : StandardCharsets.UTF_8;
    }

    private String processLine(String str, ArrayList<String> arrayList) {
        String trim = str.trim();
        StringBuilder sb = new StringBuilder(trim);
        Matcher matcher = SUBRIP_TAG_PATTERN.matcher(trim);
        int i = 0;
        while (matcher.find()) {
            String group = matcher.group();
            arrayList.add(group);
            int start = matcher.start() - i;
            int length = group.length();
            sb.replace(start, start + length, "");
            i += length;
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
        if (r15.equals(androidx.media3.extractor.text.subrip.SubripParser.ALIGN_TOP_RIGHT) != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
        if (r15.equals(androidx.media3.extractor.text.subrip.SubripParser.ALIGN_TOP_LEFT) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
        if (r15.equals(androidx.media3.extractor.text.subrip.SubripParser.ALIGN_MID_RIGHT) != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0059, code lost:
        if (r15.equals(androidx.media3.extractor.text.subrip.SubripParser.ALIGN_MID_LEFT) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r15.equals(androidx.media3.extractor.text.subrip.SubripParser.ALIGN_BOTTOM_RIGHT) != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0062, code lost:
        r14.setPositionAnchor(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
        if (r15.equals(androidx.media3.extractor.text.subrip.SubripParser.ALIGN_BOTTOM_LEFT) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
        r14.setPositionAnchor(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0084, code lost:
        if (r15.equals(androidx.media3.extractor.text.subrip.SubripParser.ALIGN_TOP_RIGHT) != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008b, code lost:
        if (r15.equals(androidx.media3.extractor.text.subrip.SubripParser.ALIGN_TOP_MID) != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0092, code lost:
        if (r15.equals(androidx.media3.extractor.text.subrip.SubripParser.ALIGN_TOP_LEFT) != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0094, code lost:
        r14.setLineAnchor(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ab, code lost:
        if (r15.equals(androidx.media3.extractor.text.subrip.SubripParser.ALIGN_BOTTOM_RIGHT) != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b2, code lost:
        if (r15.equals(androidx.media3.extractor.text.subrip.SubripParser.ALIGN_BOTTOM_MID) != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b9, code lost:
        if (r15.equals(androidx.media3.extractor.text.subrip.SubripParser.ALIGN_BOTTOM_LEFT) != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00bb, code lost:
        r14.setLineAnchor(2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Cue buildCue(Spanned spanned, String str) {
        Cue.Builder text = new Cue.Builder().setText(spanned);
        if (str == null) {
            return text.build();
        }
        switch (str.hashCode()) {
            case -685620710:
                break;
            case -685620679:
                str.equals(ALIGN_BOTTOM_MID);
                text.setPositionAnchor(1);
                break;
            case -685620648:
                break;
            case -685620617:
                break;
            case -685620586:
                str.equals(ALIGN_MID_MID);
                text.setPositionAnchor(1);
                break;
            case -685620555:
                break;
            case -685620524:
                break;
            case -685620493:
                str.equals(ALIGN_TOP_MID);
                text.setPositionAnchor(1);
                break;
            case -685620462:
                break;
            default:
                text.setPositionAnchor(1);
                break;
        }
        switch (str.hashCode()) {
            case -685620710:
                break;
            case -685620679:
                break;
            case -685620648:
                break;
            case -685620617:
                str.equals(ALIGN_MID_LEFT);
                text.setLineAnchor(1);
                break;
            case -685620586:
                str.equals(ALIGN_MID_MID);
                text.setLineAnchor(1);
                break;
            case -685620555:
                str.equals(ALIGN_MID_RIGHT);
                text.setLineAnchor(1);
                break;
            case -685620524:
                break;
            case -685620493:
                break;
            case -685620462:
                break;
            default:
                text.setLineAnchor(1);
                break;
        }
        return text.setPosition(getFractionalPositionForAnchorType(text.getPositionAnchor())).setLine(getFractionalPositionForAnchorType(text.getLineAnchor()), 0).build();
    }

    private static long parseTimecode(Matcher matcher, int i) {
        String group = matcher.group(i + 1);
        long parseLong = (group != null ? Long.parseLong(group) * DurationKt.MILLIS_IN_HOUR : 0L) + (Long.parseLong((String) Preconditions.checkNotNull(matcher.group(i + 2))) * 60000) + (Long.parseLong((String) Preconditions.checkNotNull(matcher.group(i + 3))) * 1000);
        String group2 = matcher.group(i + 4);
        if (group2 != null) {
            parseLong += Long.parseLong(group2);
        }
        return parseLong * 1000;
    }

    public static float getFractionalPositionForAnchorType(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return END_FRACTION;
                }
                throw new IllegalArgumentException();
            }
            return 0.5f;
        }
        return 0.08f;
    }
}
