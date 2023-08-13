package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.exception.RegraNegocioException;
import com.algaworks.junit.blog.modelo.Editor;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CadastroEditorTest {

    CadastroEditor cadastroEditor;
    Editor editor;
    ArmazenamentoEditorFixoEmMemoria armazenamentoEditor;



    @BeforeEach
    void beforeEach(){
        editor = new Editor(null,"Elvis","elvis@email.com", BigDecimal.TEN,true);

        armazenamentoEditor = new ArmazenamentoEditorFixoEmMemoria();

        cadastroEditor = new CadastroEditor(
                armazenamentoEditor,
                new GerenciadorEnvioEmail(){
                    @Override
                    public void enviarEmail(Mensagem mensagem){
                        System.out.println("Enviando mensagem para " + mensagem.getDestinatario());
                    }
                }
        );
    }

    @Test
    public void Dado_um_editor_valido_Quando_criar_Entao_deve_retornar_um_id_de_cadastro(){
        Editor editorSalvo = cadastroEditor.criar(editor);

        assertEquals(1L, editorSalvo.getId());
        assertTrue(armazenamentoEditor.chamouSalvar);
    }

    @Test
    public void Dado_um_editor_null_Quando_criar_Entao_deve_lancar_exception(){
        assertThrows(NullPointerException.class, () -> cadastroEditor.criar(null));
        assertFalse(armazenamentoEditor.chamouSalvar);

    }

    @Test
    public void Dado_um_editor_com_email_existente_Quando_criar_Entao_nao_deve_salvar(){
        editor.setEmail("elvisjulius@email.com");
        try {
            cadastroEditor.criar(editor);
        }catch (RegraNegocioException e){ }
        assertFalse(armazenamentoEditor.chamouSalvar);
    }


}