package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LinkAnnotation.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/LinkAnnotation;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "()V", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "getLinkInteractionListener", "()Landroidx/compose/ui/text/LinkInteractionListener;", "styles", "Landroidx/compose/ui/text/TextLinkStyles;", "getStyles", "()Landroidx/compose/ui/text/TextLinkStyles;", "Clickable", "Url", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LinkAnnotation implements AnnotatedString.Annotation {
    public static final int $stable = 0;

    public /* synthetic */ LinkAnnotation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract LinkInteractionListener getLinkInteractionListener();

    public abstract TextLinkStyles getStyles();

    private LinkAnnotation() {
    }

    /* compiled from: LinkAnnotation.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ(\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/LinkAnnotation$Url;", "Landroidx/compose/ui/text/LinkAnnotation;", "url", "", "styles", "Landroidx/compose/ui/text/TextLinkStyles;", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextLinkStyles;Landroidx/compose/ui/text/LinkInteractionListener;)V", "getLinkInteractionListener", "()Landroidx/compose/ui/text/LinkInteractionListener;", "getStyles", "()Landroidx/compose/ui/text/TextLinkStyles;", "getUrl", "()Ljava/lang/String;", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Url extends LinkAnnotation {
        public static final int $stable = 8;
        private final LinkInteractionListener linkInteractionListener;
        private final TextLinkStyles styles;
        private final String url;

        public /* synthetic */ Url(String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : textLinkStyles, (i & 4) != 0 ? null : linkInteractionListener);
        }

        public final String getUrl() {
            return this.url;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public TextLinkStyles getStyles() {
            return this.styles;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public LinkInteractionListener getLinkInteractionListener() {
            return this.linkInteractionListener;
        }

        public Url(String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
            super(null);
            this.url = str;
            this.styles = textLinkStyles;
            this.linkInteractionListener = linkInteractionListener;
        }

        public static /* synthetic */ Url copy$default(Url url, String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener, int i, Object obj) {
            if ((i & 1) != 0) {
                str = url.url;
            }
            if ((i & 2) != 0) {
                textLinkStyles = url.getStyles();
            }
            if ((i & 4) != 0) {
                linkInteractionListener = url.getLinkInteractionListener();
            }
            return url.copy(str, textLinkStyles, linkInteractionListener);
        }

        public final Url copy(String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
            return new Url(str, textLinkStyles, linkInteractionListener);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Url) {
                Url url = (Url) obj;
                return Intrinsics.areEqual(this.url, url.url) && Intrinsics.areEqual(getStyles(), url.getStyles()) && Intrinsics.areEqual(getLinkInteractionListener(), url.getLinkInteractionListener());
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.url.hashCode() * 31;
            TextLinkStyles styles = getStyles();
            int hashCode2 = (hashCode + (styles != null ? styles.hashCode() : 0)) * 31;
            LinkInteractionListener linkInteractionListener = getLinkInteractionListener();
            return hashCode2 + (linkInteractionListener != null ? linkInteractionListener.hashCode() : 0);
        }

        public String toString() {
            return "LinkAnnotation.Url(url=" + this.url + ')';
        }
    }

    /* compiled from: LinkAnnotation.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ(\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "Landroidx/compose/ui/text/LinkAnnotation;", "tag", "", "styles", "Landroidx/compose/ui/text/TextLinkStyles;", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextLinkStyles;Landroidx/compose/ui/text/LinkInteractionListener;)V", "getLinkInteractionListener", "()Landroidx/compose/ui/text/LinkInteractionListener;", "getStyles", "()Landroidx/compose/ui/text/TextLinkStyles;", "getTag", "()Ljava/lang/String;", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Clickable extends LinkAnnotation {
        public static final int $stable = 8;
        private final LinkInteractionListener linkInteractionListener;
        private final TextLinkStyles styles;
        private final String tag;

        public /* synthetic */ Clickable(String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : textLinkStyles, linkInteractionListener);
        }

        public final String getTag() {
            return this.tag;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public TextLinkStyles getStyles() {
            return this.styles;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public LinkInteractionListener getLinkInteractionListener() {
            return this.linkInteractionListener;
        }

        public Clickable(String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
            super(null);
            this.tag = str;
            this.styles = textLinkStyles;
            this.linkInteractionListener = linkInteractionListener;
        }

        public static /* synthetic */ Clickable copy$default(Clickable clickable, String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener, int i, Object obj) {
            if ((i & 1) != 0) {
                str = clickable.tag;
            }
            if ((i & 2) != 0) {
                textLinkStyles = clickable.getStyles();
            }
            if ((i & 4) != 0) {
                linkInteractionListener = clickable.getLinkInteractionListener();
            }
            return clickable.copy(str, textLinkStyles, linkInteractionListener);
        }

        public final Clickable copy(String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
            return new Clickable(str, textLinkStyles, linkInteractionListener);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Clickable) {
                Clickable clickable = (Clickable) obj;
                return Intrinsics.areEqual(this.tag, clickable.tag) && Intrinsics.areEqual(getStyles(), clickable.getStyles()) && Intrinsics.areEqual(getLinkInteractionListener(), clickable.getLinkInteractionListener());
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.tag.hashCode() * 31;
            TextLinkStyles styles = getStyles();
            int hashCode2 = (hashCode + (styles != null ? styles.hashCode() : 0)) * 31;
            LinkInteractionListener linkInteractionListener = getLinkInteractionListener();
            return hashCode2 + (linkInteractionListener != null ? linkInteractionListener.hashCode() : 0);
        }

        public String toString() {
            return "LinkAnnotation.Clickable(tag=" + this.tag + ')';
        }
    }
}
