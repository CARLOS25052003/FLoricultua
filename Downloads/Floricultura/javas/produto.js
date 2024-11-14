document.addEventListener("DOMContentLoaded", function () {
  // Produtos como exemplo
  const produtos = {
    1: {
      nome: "Orquídea",
      imagem: "../img/buque-de-flores-bleissima.png",
      precoOriginal: "R$ 65,90",
      precoDesconto: "R$ 59,90",
      desconto: "10% OFF",
      ranking: "1º Mais vendida",
      descricao: "Esta orquídea é uma excelente escolha para presentear. Sua beleza única e sua elegância fazem dela a primeira mais vendida, encantando a todos com sua sofisticação."
    },
    2: {
      nome: "Astromélia",
      imagem: "../img/89651916cb82db7a0a.png",
      precoOriginal: "R$ 39,90",
      descricao: "As astromélias são flores encantadoras, ideais para quem busca algo colorido e delicado. Perfeitas para qualquer ambiente e a 2ª mais vendida na loja."
    },
    3: {
      nome: "Flores Linha Premium",
      imagem: "../img/buque_mix_de_flores_242_1_20230109105251.png",
      precoOriginal: "R$ 105,90",
      precoDesconto: "R$ 89,90",
      desconto: "15% OFF",
      ranking: "3º Mais vendida",
      descricao: "Com uma combinação perfeita de flores de qualidade, este buquê da linha Premium é ideal para ocasiões especiais. Seu preço atrativo com 15% de desconto o torna irresistível."
    },
    4: {
      nome: "Buquê Girassol",
      imagem: "../img/buquê-7-rosas-amardlas-e-um-girassol.png",
      precoOriginal: "R$ 99,90",
      precoDesconto: null, // Produto sem desconto
      desconto: null,      // Produto sem desconto
      descricao: "O buquê Girassol traz a energia do sol e é perfeito para quem busca algo alegre e vibrante. Ideal para presentear em momentos de celebração."
    },
    5: {
      nome: "Buquê Rosas Brancas",
      imagem: "../img/rosasbrancas.png",
      precoOriginal: "R$ 199,49",
      precoDesconto: null, // Produto sem desconto
      desconto: null,      // Produto sem desconto
      descricao: "As rosas brancas são símbolo de paz e pureza. Este buquê é ideal para transmitir sentimentos sinceros e é uma escolha sofisticada para qualquer ocasião."
    },
    6: {
      nome: "Buquê Crisantemo",
      imagem: "../img/s-buque-flor-do-campo.png",
      precoOriginal: "R$ 59,49",
      precoDesconto: null, // Produto sem desconto
      desconto: null,      // Produto sem desconto
      descricao: "O buquê crisantemo é uma opção delicada e cheia de significado. Perfeito para quem busca flores elegantes e com um toque rústico."
    },
    7: {
      nome: "Flores Rosas Especiais",
      imagem: "../img/floresta100275-2_1_1.png",
      precoOriginal: "R$ 200,00",
      precoDesconto: "R$ 99,99",
      desconto: "50% OFF",
      descricao: "Essas flores especiais são perfeitas para marcar um momento único. Com 50% de desconto, elas se tornam uma escolha imperdível para quem busca beleza e sofisticação."
    },
    8: {
      nome: "Buquê Gérberas",
      imagem: "../img/gebreas.png",
      precoOriginal: "R$ 159,49",
      precoDesconto: null, // Produto sem desconto
      desconto: null,      // Produto sem desconto
      descricao: "O buquê Gérberas é perfeito para quem busca flores vibrantes e cheias de vida. Com sua cor intensa e formato marcante, é ideal para qualquer comemoração."
    },
    9: {
      nome: "Buquê de Flores Naturais",
      imagem: "../img/naturais.png",
      precoOriginal: "R$ 159,00",
      precoDesconto: null, // Produto sem desconto
      desconto: null,      // Produto sem desconto
      descricao: "Este buquê é uma opção natural e charmosa para presentear. Suas flores frescas trazem um toque de frescor e naturalidade, perfeito para todos os momentos."
    },
    10: {
      nome: "Buquê de Rosas Gigante",
      imagem: "../img/gigante.png",
      precoOriginal: "R$ 559,00",
      precoDesconto: null, // Produto sem desconto
      desconto: null,      // Produto sem desconto
      descricao: "O buquê de rosas gigante é para quem busca algo grandioso e inesquecível. Perfeito para ocasiões especiais e para impressionar com sua beleza inconfundível."
    },
    11: {
      nome: "Buquê Nobre",
      imagem: "../img/nobres.png",
      precoOriginal: "R$ 259,00",
      precoDesconto: null, // Produto sem desconto
      desconto: null,      // Produto sem desconto
      descricao: "O buquê nobre é composto por flores selecionadas, garantindo sofisticação e elegância. Ideal para ocasiões especiais e momentos de celebração."
    },
    12: {
      nome: "Arranjo Girassol",
      imagem: "../img/arranjogirasol.png",
      precoOriginal: "R$ 59,99",
      precoDesconto: null, // Produto sem desconto
      desconto: null,      // Produto sem desconto
      descricao: "O arranjo girassol é perfeito para quem deseja trazer luz e alegria ao ambiente. Um presente simples e encantador para qualquer ocasião."
    },
    13: {
      nome: "Flores Roxas Especiais",
      imagem: "../img/floresroxas.png",
      precoOriginal: "R$ 450,69",
      precoDesconto: "R$ 259,99",
      desconto: "42% OFF",
      descricao: "As flores roxas especiais são exóticas e elegantes, perfeitas para quem deseja algo diferente. Com 42% de desconto, esse buquê torna-se uma opção irresistível."
    }
  };


  // Obtendo o ID do produto da URL (exemplo: /produto.html?id=1)
  const urlParams = new URLSearchParams(window.location.search);
  const produtoId = urlParams.get("id");

  if (produtoId && produtos[produtoId]) {
    const produto = produtos[produtoId];

    // Atualizando a página com os detalhes do produto
    document.getElementById("produtoNome").textContent = produto.nome;
    document.getElementById("produtoImagem").src = produto.imagem;
    document.getElementById("produtoPrecoOriginal").textContent = produto.precoOriginal;
    document.getElementById("produtoPreco").textContent = produto.precoDesconto || produto.precoOriginal;  // Exibe o preço original se não houver desconto
    document.querySelector(".produto-detalhes__ranking").textContent = produto.ranking;
    document.getElementById("produtoDescricao").textContent = produto.descricao;

    // Se não houver desconto, oculta a seção de desconto
    if (!produto.desconto) {
      document.querySelector(".produto-detalhes__desconto").style.display = "none";
      document.querySelector(".produto__preco--original").style.display = "none"; // Oculta o preço original
    } else {
      document.getElementById("produtoDesconto").textContent = produto.desconto;
    }
  }
});
