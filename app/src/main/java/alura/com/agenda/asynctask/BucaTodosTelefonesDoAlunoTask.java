package alura.com.agenda.asynctask;

import android.os.AsyncTask;
import java.util.List;
import alura.com.agenda.database.Agenda.dao.TelefoneDAO;
import alura.com.agenda.model.Aluno;
import alura.com.agenda.model.Telefone;

public class BucaTodosTelefonesDoAlunoTask extends AsyncTask<Void, Void, List<Telefone>>{
    private final TelefoneDAO telefoneDAO;
    private final Aluno aluno;
    private final TelefonesDoAlunoEncontradoListener listener;

    public BucaTodosTelefonesDoAlunoTask(TelefoneDAO telefoneDAO,
                                         Aluno aluno,
                                         TelefonesDoAlunoEncontradoListener listener) {

        this.telefoneDAO = telefoneDAO;
        this.aluno = aluno;
        this.listener = listener;
    }

    @Override
    protected List<Telefone> doInBackground(Void... voids) {
        return  telefoneDAO
                .buscaTodosTelefonesDoAluno(aluno.getId());
    }

    @Override
    protected void onPostExecute(List<Telefone> telefones){
        super.onPostExecute(telefones);
        listener.quadoEncontrados(telefones);
    }

    public interface TelefonesDoAlunoEncontradoListener{
        void quadoEncontrados(List<Telefone> telefones);
    }
}

