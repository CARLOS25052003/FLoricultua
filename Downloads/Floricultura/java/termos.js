document.addEventListener("DOMContentLoaded", function() {
  const accordionItems = document.querySelectorAll('.accordion__item');

  accordionItems.forEach(item => {
    item.addEventListener('click', function() {
      const content = this.nextElementSibling;
      // Toggle o display da seção de conteúdo
      if (content.style.display === "block") {
        content.style.display = "none";
      } else {
        content.style.display = "block";
      }
    });
  });
});
