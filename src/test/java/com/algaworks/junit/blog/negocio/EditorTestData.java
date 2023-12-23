package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.modelo.Editor;

import java.math.BigDecimal;

public class EditorTestData {
    private EditorTestData(){

    }
    public static Editor umEditorNovo(){
    return new Editor(null,"Elvis", "elvis@email.com", BigDecimal.TEN, true);
    }

    public static Editor umEditorExistente(){
        return new Editor(1L,"Elvis", "elvis@email.com", BigDecimal.TEN, true);
    }

    public static Editor umEditorComIdInexistente(){
        return new Editor(99L,"Elvis Julius", "elvisjulius@email.com", BigDecimal.TEN, true);
    }
}
