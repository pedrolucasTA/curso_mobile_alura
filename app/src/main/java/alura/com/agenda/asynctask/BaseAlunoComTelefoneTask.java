package alura.com.agenda.asynctask;

import android.os.AsyncTask;
import alura.com.agenda.model.Telefone;

abstract class BaseAlunoComTelefoneTask extends AsyncTask<Void, Void, Void> {

    private final FinalizadaListener listener;

     BaseAlunoComTelefoneTask(FinalizadaListener listener) {
        this.listener = listener;
    }

     void vinculaAlunoComTelefone(int alunoId, Telefone... telefones) {
        for (Telefone telefone :
                telefones) {
            telefone.setAlunoId(alunoId);
        }
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.qunadoFinalizada();
    }

    public interface FinalizadaListener{
        void qunadoFinalizada();
    }

}
