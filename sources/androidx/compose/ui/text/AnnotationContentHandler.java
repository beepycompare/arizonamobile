package androidx.compose.ui.text;

import android.text.Editable;
import java.util.ArrayList;
import kotlin.Metadata;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
/* compiled from: Html.android.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J)\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0096\u0001J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\t\u0010\u0012\u001a\u00020\u000bH\u0096\u0001J&\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0016J\u0019\u0010\u0018\u001a\u00020\u000b2\u000e\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\b\u0010 \u001a\u00020\u000bH\u0002J)\u0010!\u001a\u00020\u000b2\u000e\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0096\u0001J)\u0010\"\u001a\u00020\u000b2\u000e\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\u00150\u00152\u000e\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J\u0019\u0010#\u001a\u00020\u000b2\u000e\u0010\f\u001a\n \u000e*\u0004\u0018\u00010$0$H\u0096\u0001J\u0019\u0010%\u001a\u00020\u000b2\u000e\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J\t\u0010&\u001a\u00020\u000bH\u0096\u0001J0\u0010'\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u001cH\u0016J)\u0010)\u001a\u00020\u000b2\u000e\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\u00150\u00152\u000e\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/compose/ui/text/AnnotationContentHandler;", "Lorg/xml/sax/ContentHandler;", "contentHandler", "output", "Landroid/text/Editable;", "(Lorg/xml/sax/ContentHandler;Landroid/text/Editable;)V", "bulletIndentation", "", "currentBulletSpan", "Landroidx/compose/ui/text/BulletSpanWithLevel;", "characters", "", "p0", "", "kotlin.jvm.PlatformType", "p1", "p2", "commitCurrentBulletSpan", "endDocument", "endElement", "uri", "", "localName", "qName", "endPrefixMapping", "handleAnnotationEnd", "handleAnnotationStart", "attributes", "Lorg/xml/sax/Attributes;", "handleLiEnd", "handleLiStart", "handleUlEnd", "handleUlStart", "ignorableWhitespace", "processingInstruction", "setDocumentLocator", "Lorg/xml/sax/Locator;", "skippedEntity", "startDocument", "startElement", "atts", "startPrefixMapping", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
final class AnnotationContentHandler implements ContentHandler {
    private int bulletIndentation;
    private final ContentHandler contentHandler;
    private BulletSpanWithLevel currentBulletSpan;
    private final Editable output;

    @Override // org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        this.contentHandler.characters(cArr, i, i2);
    }

    @Override // org.xml.sax.ContentHandler
    public void endDocument() {
        this.contentHandler.endDocument();
    }

    @Override // org.xml.sax.ContentHandler
    public void endPrefixMapping(String str) {
        this.contentHandler.endPrefixMapping(str);
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i2) {
        this.contentHandler.ignorableWhitespace(cArr, i, i2);
    }

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) {
        this.contentHandler.processingInstruction(str, str2);
    }

    @Override // org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
        this.contentHandler.setDocumentLocator(locator);
    }

    @Override // org.xml.sax.ContentHandler
    public void skippedEntity(String str) {
        this.contentHandler.skippedEntity(str);
    }

    @Override // org.xml.sax.ContentHandler
    public void startDocument() {
        this.contentHandler.startDocument();
    }

    @Override // org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) {
        this.contentHandler.startPrefixMapping(str, str2);
    }

    public AnnotationContentHandler(ContentHandler contentHandler, Editable editable) {
        this.contentHandler = contentHandler;
        this.output = editable;
    }

    @Override // org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if (str2 != null) {
            int hashCode = str2.hashCode();
            if (hashCode != -1555043537) {
                if (hashCode != 3453) {
                    if (hashCode == 3735 && str2.equals("ul")) {
                        handleUlStart();
                        return;
                    }
                } else if (str2.equals("li")) {
                    handleLiStart();
                    return;
                }
            } else if (str2.equals("annotation")) {
                if (attributes != null) {
                    handleAnnotationStart(attributes);
                    return;
                }
                return;
            }
        }
        this.contentHandler.startElement(str, str2, str3, attributes);
    }

    @Override // org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (str2 != null) {
            int hashCode = str2.hashCode();
            if (hashCode != -1555043537) {
                if (hashCode != 3453) {
                    if (hashCode == 3735 && str2.equals("ul")) {
                        handleUlEnd();
                        return;
                    }
                } else if (str2.equals("li")) {
                    handleLiEnd();
                    return;
                }
            } else if (str2.equals("annotation")) {
                handleAnnotationEnd();
                return;
            }
        }
        this.contentHandler.endElement(str, str2, str3);
    }

    private final void handleAnnotationStart(Attributes attributes) {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            String localName = attributes.getLocalName(i);
            if (localName == null) {
                localName = "";
            }
            String value = attributes.getValue(i);
            String str = value != null ? value : "";
            if (localName.length() > 0 && str.length() > 0) {
                int length2 = this.output.length();
                this.output.setSpan(new AnnotationSpan(localName, str), length2, length2, 17);
            }
        }
    }

    private final void handleAnnotationEnd() {
        Editable editable = this.output;
        Object[] spans = editable.getSpans(0, editable.length(), AnnotationSpan.class);
        ArrayList arrayList = new ArrayList();
        for (Object obj : spans) {
            if (this.output.getSpanFlags((AnnotationSpan) obj) == 17) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            AnnotationSpan annotationSpan = (AnnotationSpan) arrayList2.get(i);
            int spanStart = this.output.getSpanStart(annotationSpan);
            int length = this.output.length();
            this.output.removeSpan(annotationSpan);
            if (spanStart != length) {
                this.output.setSpan(annotationSpan, spanStart, length, 33);
            }
        }
    }

    private final void handleUlStart() {
        commitCurrentBulletSpan();
        this.bulletIndentation++;
    }

    private final void handleUlEnd() {
        commitCurrentBulletSpan();
        this.bulletIndentation--;
    }

    private final void handleLiStart() {
        commitCurrentBulletSpan();
        this.currentBulletSpan = new BulletSpanWithLevel(BulletKt.getDefaultBullet(), this.bulletIndentation, this.output.length());
    }

    private final void handleLiEnd() {
        commitCurrentBulletSpan();
    }

    private final void commitCurrentBulletSpan() {
        BulletSpanWithLevel bulletSpanWithLevel = this.currentBulletSpan;
        if (bulletSpanWithLevel != null) {
            this.output.setSpan(bulletSpanWithLevel, bulletSpanWithLevel.getStart(), this.output.length(), 33);
        }
        this.currentBulletSpan = null;
    }
}
