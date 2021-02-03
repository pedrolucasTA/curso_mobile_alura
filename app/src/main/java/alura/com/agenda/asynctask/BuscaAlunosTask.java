package alura.com.agenda.asynctask;

import android.os.AsyncTask;

import java.util.List;

import alura.com.agenda.database.Agenda.dao.AlunoDao;
import alura.com.agenda.model.Aluno;
import alura.com.agenda.ui.adapter.ListaAlunosAdapter;

public class BuscaAlunosTask extends AsyncTask<Void, Void, List<Aluno>>{
    private final AlunoDao dao;
    private final ListaAlunosAdapter adapter;

    public BuscaAlunosTask(AlunoDao dao, ListaAlunosAdapter adapter) {

        this.dao = dao;
        this.adapter = adapter;
    }

    @Override
    protected List<Aluno> doInBackground(Void[] objects) {
        return dao.todos();
    }

    @Override
    protected  void onPostExecute(List<Aluno> todosAlunos){
        super.onPostExecute(todosAlunos);
        adapter.atualiza(todosAlunos);
    }
}
