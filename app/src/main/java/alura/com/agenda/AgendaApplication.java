package alura.com.agenda;

import android.app.Application;

import alura.com.agenda.dao.AlunoDAO;
import alura.com.agenda.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        super.onCreate();
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Pedro", "1234", "pedro@alura.com"));
        dao.salva(new Aluno("Guta", "1234", "guta@alura.com"));
    }
}
