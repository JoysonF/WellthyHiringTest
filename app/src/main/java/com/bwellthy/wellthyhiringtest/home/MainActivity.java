package com.bwellthy.wellthyhiringtest.home;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.bwellthy.wellthyhiringtest.home.MainContract.Presenter;
import com.bwellthy.wellthyhiringtest.R;
import com.bwellthy.wellthyhiringtest.repository.Repository;
import com.bwellthy.wellthyhiringtest.repository.RepositoryImpl;

public class MainActivity extends AppCompatActivity implements MainContract.View {

  private EditText name;
  private EditText description;
  private FloatingActionButton fab;
  private Repository repository;
  private Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
    name = (EditText) findViewById(R.id.name);
    description = (EditText) findViewById(R.id.description);
    repository = new RepositoryImpl(getPreferences(MODE_PRIVATE));
    presenter = new MainPresenter(this, repository);

    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.fabClicked();
      }
    });
  }

  @Override
  public void setName(String name) {
    this.name.setText(name);
  }

  @Override
  public String getName() {
    return name.getText().toString();
  }

  @Override
  public void setDescription(String description) {
    this.description.setText(description);
  }

  @Override
  public String getDescription() {
    return description.getText().toString();
  }

  @Override
  public void setEditable(boolean editable) {
    name.setEnabled(editable);
    description.setEnabled(editable);
    if (editable) {
      fab.setImageResource(R.drawable.ic_save_black_24dp);
      showKeyboard();
    } else {
      fab.setImageResource(R.drawable.ic_edit_black_24dp);
    }
  }

  private void showKeyboard() {
    InputMethodManager keyboard = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    keyboard.showSoftInput(name, 0);
  }
}
