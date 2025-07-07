package com.google.thirdparty.publicsuffix;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public enum PublicSuffixType {
    PRIVATE(AbstractJsonLexerKt.COLON, AbstractJsonLexerKt.COMMA),
    REGISTRY('!', '?');
    
    private final char innerNodeCode;
    private final char leafNodeCode;

    PublicSuffixType(char innerNodeCode, char leafNodeCode) {
        this.innerNodeCode = innerNodeCode;
        this.leafNodeCode = leafNodeCode;
    }

    char getLeafNodeCode() {
        return this.leafNodeCode;
    }

    char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PublicSuffixType fromCode(char code) {
        PublicSuffixType[] values;
        for (PublicSuffixType publicSuffixType : values()) {
            if (publicSuffixType.getInnerNodeCode() == code || publicSuffixType.getLeafNodeCode() == code) {
                return publicSuffixType;
            }
        }
        throw new IllegalArgumentException("No enum corresponding to given code: " + code);
    }
}
