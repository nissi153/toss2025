function clickGenreBox(id) {
  const genres = document.querySelectorAll(".genre-box");
  const genre = document.getElementById(id);

  for (let i = 0; i < 5; i++) {
    genres[i].classList.remove("clicked");
  }

  genre.classList.add("clicked");
}

window.clickGenreBox = clickGenreBox;
