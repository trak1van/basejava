package com.urise.webapp.model;

import java.util.Objects;

public class TextSeсtion extends Section {
    private static final long serialVersionUID = 1L;
    private final String content;

    public TextSeсtion(String content) {
        Objects.requireNonNull(content, "Content must not be null");
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSeсtion that = (TextSeсtion) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
