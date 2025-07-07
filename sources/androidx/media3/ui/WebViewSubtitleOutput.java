package androidx.media3.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.ui.SpannedToHtmlConverter;
import androidx.media3.ui.SubtitleView;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
final class WebViewSubtitleOutput extends FrameLayout implements SubtitleView.Output {
    private static final float CSS_LINE_HEIGHT = 1.2f;
    private static final String DEFAULT_BACKGROUND_CSS_CLASS = "default_bg";
    private float bottomPaddingFraction;
    private final CanvasSubtitleOutput canvasSubtitleOutput;
    private float defaultTextSize;
    private int defaultTextSizeType;
    private CaptionStyleCompat style;
    private List<Cue> textCues;
    private final WebView webView;

    private static int anchorTypeToTranslatePercent(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    public WebViewSubtitleOutput(Context context) {
        this(context, null);
    }

    public WebViewSubtitleOutput(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.textCues = Collections.emptyList();
        this.style = CaptionStyleCompat.DEFAULT;
        this.defaultTextSize = 0.0533f;
        this.defaultTextSizeType = 0;
        this.bottomPaddingFraction = 0.08f;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context, attributeSet);
        this.canvasSubtitleOutput = canvasSubtitleOutput;
        WebView webView = new WebView(context, attributeSet) { // from class: androidx.media3.ui.WebViewSubtitleOutput.1
            @Override // android.webkit.WebView, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                super.onTouchEvent(motionEvent);
                return false;
            }

            @Override // android.view.View
            public boolean performClick() {
                super.performClick();
                return false;
            }
        };
        this.webView = webView;
        webView.setBackgroundColor(0);
        addView(canvasSubtitleOutput);
        addView(webView);
    }

    @Override // androidx.media3.ui.SubtitleView.Output
    public void update(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f, int i, float f2) {
        this.style = captionStyleCompat;
        this.defaultTextSize = f;
        this.defaultTextSizeType = i;
        this.bottomPaddingFraction = f2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Cue cue = list.get(i2);
            if (cue.bitmap != null) {
                arrayList.add(cue);
            } else {
                arrayList2.add(cue);
            }
        }
        if (!this.textCues.isEmpty() || !arrayList2.isEmpty()) {
            this.textCues = arrayList2;
            updateWebView();
        }
        this.canvasSubtitleOutput.update(arrayList, captionStyleCompat, f, i, f2);
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!z || this.textCues.isEmpty()) {
            return;
        }
        updateWebView();
    }

    public void destroy() {
        this.webView.destroy();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x014c, code lost:
        if (r4 != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x014f, code lost:
        if (r4 != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0151, code lost:
        r11 = androidx.media3.extractor.text.ttml.TtmlNode.LEFT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0152, code lost:
        r20 = r11;
        r18 = "top";
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0207  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateWebView() {
        float f;
        String formatInvariant;
        int i;
        boolean z;
        String str;
        int i2;
        String str2;
        Object obj;
        String str3;
        StringBuilder sb = new StringBuilder();
        String cssRgba = HtmlUtils.toCssRgba(this.style.foregroundColor);
        String convertTextSizeToCss = convertTextSizeToCss(this.defaultTextSizeType, this.defaultTextSize);
        float f2 = CSS_LINE_HEIGHT;
        sb.append(Util.formatInvariant("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", cssRgba, convertTextSizeToCss, Float.valueOf((float) CSS_LINE_HEIGHT), convertCaptionStyleToCssTextShadow(this.style)));
        HashMap hashMap = new HashMap();
        hashMap.put(HtmlUtils.cssAllClassDescendantsSelector(DEFAULT_BACKGROUND_CSS_CLASS), Util.formatInvariant("background-color:%s;", HtmlUtils.toCssRgba(this.style.backgroundColor)));
        int i3 = 0;
        while (i3 < this.textCues.size()) {
            Cue cue = this.textCues.get(i3);
            float f3 = cue.position != -3.4028235E38f ? cue.position * 100.0f : 50.0f;
            int anchorTypeToTranslatePercent = anchorTypeToTranslatePercent(cue.positionAnchor);
            if (cue.line != -3.4028235E38f) {
                if (cue.lineType == 1) {
                    f = f2;
                    if (cue.line >= 0.0f) {
                        formatInvariant = Util.formatInvariant("%.2fem", Float.valueOf(cue.line * f));
                        z = false;
                        i = 0;
                    } else {
                        formatInvariant = Util.formatInvariant("%.2fem", Float.valueOf(((-cue.line) - 1.0f) * f));
                        i = 0;
                        z = true;
                    }
                    String str4 = formatInvariant;
                    if (cue.size == -3.4028235E38f) {
                        str = Util.formatInvariant("%.2f%%", Float.valueOf(cue.size * 100.0f));
                    } else {
                        str = "fit-content";
                    }
                    String str5 = str;
                    String convertAlignmentToCss = convertAlignmentToCss(cue.textAlignment);
                    String convertVerticalTypeToCss = convertVerticalTypeToCss(cue.verticalType);
                    String convertTextSizeToCss2 = convertTextSizeToCss(cue.textSizeType, cue.textSize);
                    String cssRgba2 = HtmlUtils.toCssRgba(!cue.windowColorSet ? cue.windowColor : this.style.windowColor);
                    i2 = cue.verticalType;
                    String str6 = TtmlNode.RIGHT;
                    if (i2 == 1) {
                        if (i2 != 2) {
                            String str7 = z ? "bottom" : "top";
                            obj = TtmlNode.LEFT;
                            str2 = str7;
                        }
                    }
                    if (cue.verticalType != 2 || cue.verticalType == 1) {
                        str3 = "height";
                        int i4 = i;
                        i = anchorTypeToTranslatePercent;
                        anchorTypeToTranslatePercent = i4;
                    } else {
                        str3 = "width";
                    }
                    String str8 = str3;
                    SpannedToHtmlConverter.HtmlAndCss convert = SpannedToHtmlConverter.convert(cue.text, getContext().getResources().getDisplayMetrics().density);
                    for (String str9 : hashMap.keySet()) {
                        String str10 = (String) hashMap.put(str9, (String) hashMap.get(str9));
                        Assertions.checkState(str10 == null || str10.equals(hashMap.get(str9)));
                    }
                    sb.append(Util.formatInvariant("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i3), obj, Float.valueOf(f3), str2, str4, str8, str5, convertAlignmentToCss, convertVerticalTypeToCss, convertTextSizeToCss2, cssRgba2, Integer.valueOf(anchorTypeToTranslatePercent), Integer.valueOf(i), getBlockShearTransformFunction(cue))).append(Util.formatInvariant("<span class='%s'>", DEFAULT_BACKGROUND_CSS_CLASS));
                    if (cue.multiRowAlignment == null) {
                        sb.append(Util.formatInvariant("<span style='display:inline-block; text-align:%s;'>", convertAlignmentToCss(cue.multiRowAlignment))).append(convert.html).append("</span>");
                    } else {
                        sb.append(convert.html);
                    }
                    sb.append("</span></div>");
                    i3++;
                    f2 = f;
                } else {
                    formatInvariant = Util.formatInvariant("%.2f%%", Float.valueOf(cue.line * 100.0f));
                    if (cue.verticalType == 1) {
                        i = -anchorTypeToTranslatePercent(cue.lineAnchor);
                    } else {
                        i = anchorTypeToTranslatePercent(cue.lineAnchor);
                    }
                    f = f2;
                }
            } else {
                f = f2;
                formatInvariant = Util.formatInvariant("%.2f%%", Float.valueOf((1.0f - this.bottomPaddingFraction) * 100.0f));
                i = -100;
            }
            z = false;
            String str42 = formatInvariant;
            if (cue.size == -3.4028235E38f) {
            }
            String str52 = str;
            String convertAlignmentToCss2 = convertAlignmentToCss(cue.textAlignment);
            String convertVerticalTypeToCss2 = convertVerticalTypeToCss(cue.verticalType);
            String convertTextSizeToCss22 = convertTextSizeToCss(cue.textSizeType, cue.textSize);
            String cssRgba22 = HtmlUtils.toCssRgba(!cue.windowColorSet ? cue.windowColor : this.style.windowColor);
            i2 = cue.verticalType;
            String str62 = TtmlNode.RIGHT;
            if (i2 == 1) {
            }
            if (cue.verticalType != 2) {
            }
            str3 = "height";
            int i42 = i;
            i = anchorTypeToTranslatePercent;
            anchorTypeToTranslatePercent = i42;
            String str82 = str3;
            SpannedToHtmlConverter.HtmlAndCss convert2 = SpannedToHtmlConverter.convert(cue.text, getContext().getResources().getDisplayMetrics().density);
            while (r10.hasNext()) {
            }
            sb.append(Util.formatInvariant("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i3), obj, Float.valueOf(f3), str2, str42, str82, str52, convertAlignmentToCss2, convertVerticalTypeToCss2, convertTextSizeToCss22, cssRgba22, Integer.valueOf(anchorTypeToTranslatePercent), Integer.valueOf(i), getBlockShearTransformFunction(cue))).append(Util.formatInvariant("<span class='%s'>", DEFAULT_BACKGROUND_CSS_CLASS));
            if (cue.multiRowAlignment == null) {
            }
            sb.append("</span></div>");
            i3++;
            f2 = f;
        }
        sb.append("</div></body></html>");
        StringBuilder sb2 = new StringBuilder("<html><head><style>");
        for (String str11 : hashMap.keySet()) {
            sb2.append(str11).append("{").append((String) hashMap.get(str11)).append("}");
        }
        sb2.append("</style></head>");
        sb.insert(0, sb2.toString());
        this.webView.loadData(Base64.encodeToString(sb.toString().getBytes(StandardCharsets.UTF_8), 1), "text/html", "base64");
    }

    private static String getBlockShearTransformFunction(Cue cue) {
        String str;
        if (cue.shearDegrees != 0.0f) {
            if (cue.verticalType == 2 || cue.verticalType == 1) {
                str = "skewY";
            } else {
                str = "skewX";
            }
            return Util.formatInvariant("%s(%.2fdeg)", str, Float.valueOf(cue.shearDegrees));
        }
        return "";
    }

    private String convertTextSizeToCss(int i, float f) {
        float resolveTextSize = SubtitleViewUtils.resolveTextSize(i, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (resolveTextSize == -3.4028235E38f) {
            return "unset";
        }
        return Util.formatInvariant("%.2fpx", Float.valueOf(resolveTextSize / getContext().getResources().getDisplayMetrics().density));
    }

    private static String convertCaptionStyleToCssTextShadow(CaptionStyleCompat captionStyleCompat) {
        int i = captionStyleCompat.edgeType;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return Util.formatInvariant("-0.05em -0.05em 0.15em %s", HtmlUtils.toCssRgba(captionStyleCompat.edgeColor));
                    }
                    return "unset";
                }
                return Util.formatInvariant("0.06em 0.08em 0.15em %s", HtmlUtils.toCssRgba(captionStyleCompat.edgeColor));
            }
            return Util.formatInvariant("0.1em 0.12em 0.15em %s", HtmlUtils.toCssRgba(captionStyleCompat.edgeColor));
        }
        return Util.formatInvariant("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", HtmlUtils.toCssRgba(captionStyleCompat.edgeColor));
    }

    private static String convertVerticalTypeToCss(int i) {
        if (i != 1) {
            if (i == 2) {
                return "vertical-lr";
            }
            return "horizontal-tb";
        }
        return "vertical-rl";
    }

    private static String convertAlignmentToCss(Layout.Alignment alignment) {
        if (alignment == null) {
            return TtmlNode.CENTER;
        }
        int i = AnonymousClass2.$SwitchMap$android$text$Layout$Alignment[alignment.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return TtmlNode.CENTER;
            }
            return TtmlNode.END;
        }
        return TtmlNode.START;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.media3.ui.WebViewSubtitleOutput$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$text$Layout$Alignment;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            $SwitchMap$android$text$Layout$Alignment = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
