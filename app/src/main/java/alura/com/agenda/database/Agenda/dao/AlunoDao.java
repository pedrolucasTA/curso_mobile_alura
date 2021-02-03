package alura.com.agenda.database.Agenda.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import alura.com.agenda.model.Aluno;

@Dao
public interface AlunoDao {
    @Insert
    Long salva(Aluno aluno);

    @Query("SELECT * FROM aluno")
    List<Aluno> todos();

    @Delete
    void remove(Aluno aluno);

    @Update
    void edita(Aluno aluno);
}
