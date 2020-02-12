insert into jokes.category (id, name) values (1, 'programming'), (2, 'one liner'), (3, 'dog') ON CONFLICT DO NOTHING;
insert into jokes.joke (id, id_category, content) values
    (0, 3, 'In a park people come across a man playing chess against a dog. They were astonished and said: "What a clever dog!" But the man protested and replied: "No, no, he isn''t that clever. I''m leading by three games to one!"'), 
    (1, 1, ' My wifi suddenly stop working then I realized that my neighbors have not paid the bill. How irresponsible people are.'),
    (2, 1, 'If at first you don''t succeed, call it version 1.0.'),
    (3, 2, ' One day YouTube, Twitter and Facebook will merge and be known as YouTwitFace :)'),
    (4, 2, 'If life is handing you melons... You just might be dyslexic.')
ON CONFLICT DO NOTHING;