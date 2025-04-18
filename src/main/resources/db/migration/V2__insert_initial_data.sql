-- Inserir papéis (roles)
INSERT INTO roles (role_name) VALUES
    ('admin_full'),
    ('cliente_free'),
    ('cliente_vip'),
    ('admin_parceiro');

-- Inserir o usuário admin (com senha criptografada por bcrypt)
INSERT INTO users (email, password, name) VALUES
    ('admin@tacaro.com', '$2a$10$7DNi9s0Wy1YJtI8pl0VxM.Wgs1D1Kr1RAmk5T5B8QZ25tM7EoqzJ6', 'Admin Full'); -- Senha: "admin123" com bcrypt

-- Associar o admin ao papel de "admin_full"
INSERT INTO user_roles (user_id, role_id)
SELECT users.id, roles.id FROM users, roles
WHERE users.email = 'admin@tacaro.com' AND roles.role_name = 'admin_full';
